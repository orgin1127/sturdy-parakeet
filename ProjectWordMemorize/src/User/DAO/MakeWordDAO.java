package User.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import User.UI2.UICompilation;
import User.VO.CustomMemorize;
import User.VO.UserInfomation;

public class MakeWordDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	Scanner sc = new Scanner(System.in);
	UICompilation uic = new UICompilation();
	
	public void customWordPhase(UserInfomation user) {
		while (true) {
			UICompilation.clear();
			uic.customWordPhase();
			String selectCustomPhase = sc.nextLine();
			int intselectCustomPhase = 99;
			if (Pattern.matches("^[0-9]*$", selectCustomPhase)) {
				intselectCustomPhase = Integer.parseInt(selectCustomPhase);
			}
			else {
				System.out.println("[お知らせ] 正しいメニュ―を選択して下さい");
				continue;
			}
			switch(intselectCustomPhase) {
			case 1:
				printCustomWords(user);
				break;
			case 2:
				UICompilation.clear();
				SqlSession session = null;
				try {
					session = factory.openSession();
					UserMapper um = session.getMapper(UserMapper.class);
					if (um.makeCustomWord(makeCustomWord(user)) == 1) {
						System.out.println("登録に成功しました。");
						session.commit();
						UICompilation.delay();
						UICompilation.clear();
					}
					else {
						System.out.println("登録に失敗しました。");
						UICompilation.delay();
						UICompilation.clear();
					}
				}
				catch (Exception e) {
						
				}
				finally {
					if (session != null) session.close();
				}
				break;
			case 3:
				break;
			case 0:
				UICompilation.clear();
				return;
			}
		}
	}
	
	
	public CustomMemorize makeCustomWord(UserInfomation user) {
		SqlSession session = null;
		CustomMemorize customedWord = null;
		System.out.println("===================================");
		System.out.print("新しい単語を入力してください：");
		String customKanji = sc.nextLine();
		System.out.print("よみがなを入力してください：");
		String customYomigana = sc.nextLine();
		System.out.print("意味を入力してください：");
		String customMeaning = sc.nextLine();
		customedWord = new CustomMemorize(user.getAccountnumber(), customKanji
									, customYomigana, customMeaning);
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			String check = um.checkDuplicateWord(customedWord);
			session.commit();
			if (check != null) {
				System.err.println("もうすでに登録されている単語です。");
				System.out.println("");
				System.out.println("");
				UICompilation.delay();
				UICompilation.clear();
				return null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		} 
		return customedWord;
	}
	
	public void printCustomWords (UserInfomation user) {
		SqlSession session = null;
		ArrayList<CustomMemorize> list = new ArrayList<>();
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			list = um.viewWordCustom(user);
			int cnt = 0;
			if (list == null) {
				System.err.println("登録された単語がございません。");
				UICompilation.delay();
				UICompilation.clear();
				return;
			}
			Collections.shuffle(list);
			HERE:
			while (true) {
				System.out.println("");
				System.out.println("");
				System.out.println("\t"+"単語番号: "+cnt+" "+list.get(cnt)+"\t");
				System.out.println("");
				System.out.println("");
				System.out.print("次の単語を読みます？(y/n) ");
				String wordViewContinue = sc.nextLine();
				if (wordViewContinue.toLowerCase().equals("y")) {
					cnt++;
					try {
						list.get(cnt);
						UICompilation.clear();
						continue HERE;
					}
					catch (Exception e) {
						System.err.println("読む単語がございません。最後の単語です。");
						cnt--;
						UICompilation.delay();
						UICompilation.clear();
						continue HERE;
					}
				}
				else if (wordViewContinue.toLowerCase().equals("n")) {
					return;
				}
				else {
					System.out.println("入力が違います。");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
	}

}
