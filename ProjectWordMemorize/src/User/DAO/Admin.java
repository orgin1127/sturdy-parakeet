package User.DAO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import User.UI2.UICompilation;
import User.VO.N1;
import User.VO.N2;
import User.VO.N3;
import User.VO.UserInfomation;
import User.VO.Word;

public class Admin {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	Scanner sc = new Scanner(System.in);
	UICompilation ui = new UICompilation();
	
	public void adminMode(UserInfomation user) {
		while (true) {
			UICompilation.clear();
			System.out.println("1. ユーザーリストを見る");
			System.out.println("2. ユーザー削除");
			System.out.println("3. 単語追加");
			System.out.println("4. 単語削除");
			System.out.println("0. 戻る");
			System.out.print("=> ");
			String select = sc.nextLine();
			int number = 99;
			
			if (Pattern.matches("^[0-9]*$", select)) {
				number = Integer.parseInt(select);
				switch (number) {
				case 1:
					printUser();
					break;
				case 2:
					deleteUser();
					break;
				case 3:
					wordInsert();
					break;
				case 4:
					wordDelete();
					break;
				case 0:
					return;
				}
			}
			else {
				System.out.println("正しい番号を入力してください。");
				UICompilation.delay();
				UICompilation.clear();
				continue;
			}
		}
	}
	
	public void deleteUser() {
		SqlSession session = null;
		ArrayList<UserInfomation> userList = new ArrayList<>();
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			System.out.println("削除するユーザーのアカウント番号を入力して下さい。");
			userList = um.printAllUser();
			for (UserInfomation userInfomation : userList) {
				System.out.println(userInfomation.toString());
			}
			while (true) {
				System.out.println("削除するユーザーのアカウント番号を入力してください。");
				System.out.println("戻りたい場合はエンターをもう一回押して下さい");
				System.out.print(" => ");
				String answer = sc.nextLine();
				if (answer.isEmpty()) {
					return;
				}
				if (Pattern.matches("^[0-9]*$", answer)) {
					int number = Integer.parseInt(answer);
					if (um.adminUserDelete(number)==1) {
						session.commit();
						System.out.println("削除成功");
						UICompilation.delay();
						UICompilation.clear();
						return;
					}
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
	
	public void printUser() {
		SqlSession session = null;
		ArrayList<UserInfomation> userList = new ArrayList<>();
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			userList = um.printAllUser();
			session.commit();
			for (UserInfomation userInfomation : userList) {
				System.out.println(userInfomation.toString());
			}
			while (true) {
				System.out.print("メニュー画面に戻りますか？(Y/N) => ");
				String answer = sc.nextLine();
				if (answer.toLowerCase().equals("y")&&answer.length() == 1) {
					return;
				}
				else if (answer.toLowerCase().equals("n")&&answer.length() == 1) {
					UICompilation.delay();
					UICompilation.clear();
					continue;
				}
				else {
					System.out.println("入力が違います。もう一度選択して下さい。");
					UICompilation.delay();
					UICompilation.clear();
					continue;
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
	
	public void wordDelete() {
		SqlSession session = null;
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			while (true) {
				System.out.println("削除したい単語を入力して下さい。");
				System.out.println("戻りたい場合はエンターをもう一回押して下さい");
				System.out.print("=> ");
				String word = sc.nextLine();
				if (word.isEmpty()) {
					return;
				}
				ArrayList<Word> list = um.searchWord(word);
				if (list.isEmpty()) {
					System.out.println("登録された単語が見つかりません。");
					UICompilation.delay();
					UICompilation.clear();
					continue;
				}
				else {
					while (true) {
						for (Word word2 : list) {
							System.out.println(word2.toString());
						}
						System.out.println("=================================");
						System.out.println("削除する単語の番号を入力してください。");
						System.out.println("戻りたい場合はエンターをもう一回押して下さい");
						System.out.print("=> ");
						String str = sc.nextLine();
						if (Pattern.matches("^[0-9]*$", str)) {
							int number = Integer.parseInt(str);
							if (um.adminWordDelete(number)==1) {
								System.out.println("削除成功");
								session.commit();
								UICompilation.delay();
								UICompilation.clear();
								return;
							}
							else {
								System.out.println("削除失敗");
								continue;
							}
						}
						else if (str.isEmpty()) {
							return;
						}
						else {
							System.out.println("正しい番号を入力して下さい。");
							UICompilation.delay();
							UICompilation.clear();
							continue;
						}
					}
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
	
	
	public boolean wordInsert() {
		boolean result = false;
		SqlSession session = null;
		String kanji = "";
		String yomigana = "";
		String meaning = "";
		String levels = "";
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			while (true) {
				System.out.print("入力する単語のレベル(N1, N2, N3)");
				System.out.println("戻りたい場合はエンターをもう一回押して下さい");
				System.out.print("=> ");
				levels = sc.nextLine();
				if (levels.toLowerCase().equals("n1")) {
					System.out.print("漢字：");
					kanji = sc.nextLine();
					System.out.print("よみがな：");
					yomigana = sc.nextLine();
					System.out.print("意味：");
					meaning = sc.nextLine();
					N1 n1 = new N1(kanji, yomigana, meaning, levels);
					if (um.adminWordInsertN1(n1) == 1) {
						session.commit();
						System.out.println("登録に成功しました。");
						result = true;
						UICompilation.delay();
						UICompilation.clear();
						break;
					}
				}
				else if (levels.toLowerCase().equals("n2")) {
					System.out.print("漢字：");
					kanji = sc.nextLine();
					System.out.print("よみがな：");
					yomigana = sc.nextLine();
					System.out.print("意味：");
					meaning = sc.nextLine();
					N2 n2 = new N2(kanji, yomigana, meaning, levels);
					if (um.adminWordInsertN2(n2) == 1) {
						session.commit();
						System.out.println("登録に成功しました。");
						result = true;
						UICompilation.delay();
						UICompilation.clear();
						break;
					}
				}
				else if (levels.toLowerCase().equals("n3")) {
					System.out.print("漢字：");
					kanji = sc.nextLine();
					System.out.print("よみがな：");
					yomigana = sc.nextLine();
					System.out.print("意味：");
					meaning = sc.nextLine();
					N3 n3 = new N3(kanji, yomigana, meaning, levels);
					if (um.adminWordInsertN3(n3) == 1) {
						session.commit();
						System.out.println("登録に成功しました。");
						result = true;
						UICompilation.delay();
						UICompilation.clear();
						break;
					}
				}
				else if (levels.isEmpty()) {
					break;
				}
				else {
					System.out.println("正しいレベルを入力して下さい。");
					UICompilation.delay();
					UICompilation.clear();
					continue;
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return result;
	}

}
