package User.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import User.DAO.MybatisConfig;
import User.UI2.UICompilation;
import User.VO.CustomMemorize;
import User.VO.UserInfomation;

public class UserDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	Scanner sc = new Scanner(System.in);
	UICompilation ui = new UICompilation();
	
	public boolean insertUser(UserInfomation user) {
		boolean resultOfRegist = false;
		SqlSession session = null;
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			if (um.insertUser(user) == 1) {
				resultOfRegist = true;
				session.commit();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		} 
		return resultOfRegist;
	}
	
	public UserInfomation checkUserID(String userID) {
		SqlSession session = null;
		UserInfomation user = null;
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			user = um.checkUserID(userID);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		} 
		return user;
	}
	
	public UserInfomation checkUserIsExist(String userID, String password) {
		
		UserInfomation user = new UserInfomation(userID, password);
		UserInfomation userCheck = null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			userCheck = um.checkUser(user);
			session.commit();
			if (um.checkUser(userCheck) == null){
				System.err.println("ユ―ザアカウント、または暗証番号が違います。");
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
		return userCheck;
	}
	
	
	public void afterLogin(UserInfomation user) {
		HERE:
		while (true) {
			
			ui.afterLoginMenu(); //로그인 성공 후 메뉴 출력
			
			String afterLoginSelect = sc.nextLine();
			int afterLoginSelectNumber = 0;
			if (Pattern.matches("^[0-9]*$", afterLoginSelect)) {
				afterLoginSelectNumber = Integer.parseInt(afterLoginSelect);
			}
			
			SqlSession session = null;
			ArrayList<Object> list = new ArrayList<>();
			switch (afterLoginSelectNumber) {
				case 1:
					try {
						session = factory.openSession();
						UserMapper um = session.getMapper(UserMapper.class);
						list = um.viewWordN1();
						Collections.shuffle(list);
						session.commit();
						int cnt = 0;
						while (true) {
							System.out.println("");
							System.out.println("");
							System.out.println("\t"+list.get(cnt)+"\t");
							System.out.println("");
							System.out.println("");
							System.out.print("次の単語を読みます？(y/n) ");
							String wordViewContinue = sc.nextLine();
							if (wordViewContinue.toLowerCase().equals("y")) {
								cnt++;
								UICompilation.clear();
							}
							else if (wordViewContinue.toLowerCase().equals("n")) {
								continue HERE;
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
					break;
				case 2:
					try {
						session = factory.openSession();
						UserMapper um = session.getMapper(UserMapper.class);
						list = um.viewWordN2();
						Collections.shuffle(list);
						session.commit();
						int cnt = 0;
						while (true) {
							System.out.println("");
							System.out.println("");
							System.out.println("\t"+list.get(cnt)+"\t");
							System.out.println("");
							System.out.println("");
							System.out.print("次の単語を読みます？(y/n) ");
							String wordViewContinue = sc.nextLine();
							if (wordViewContinue.toLowerCase().equals("y")) {
								cnt++;
								UICompilation.clear();
							}
							else if (wordViewContinue.toLowerCase().equals("n")) {
								UICompilation.clear();
								continue HERE;
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
					break;
				case 3:
					try {
						session = factory.openSession();
						UserMapper um = session.getMapper(UserMapper.class);
						list = um.viewWordN3();
						Collections.shuffle(list);
						session.commit();
						int cnt = 0;
						while (true) {
							System.out.println("");
							System.out.println("");
							System.out.println("\t"+list.get(cnt)+"\t");
							System.out.println("");
							System.out.println("");
							System.out.print("次の単語を読みます？(y/n) ");
							String wordViewContinue = sc.nextLine();
							if (wordViewContinue.toLowerCase().equals("y")) {
								cnt++;
								UICompilation.clear();
							}
							else if (wordViewContinue.toLowerCase().equals("n")) {
								UICompilation.clear();
								continue HERE;
							}
							else {
								System.out.println("入力が違います。");
								UICompilation.delay();
								UICompilation.clear();
							}
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						if (session != null) session.close();
					} 
					break;
				case 4:
					try {
						session = factory.openSession();
						UserMapper um = session.getMapper(UserMapper.class);
						if (um.makeCustomWord(makeCustomWord(user)) == 1) {
							System.out.println("登録に成功しました。");
							session.commit();
						}
						else {
							System.out.println("登録に失敗しました。");
						}
					}
					catch(Exception e) {
						
					}
					finally {
						if (session != null) {
							session.close();
						}
					}
				case 0:
					return;
				default:
					System.out.println("正しい番号を入力してください。");
					UICompilation.delay();
					UICompilation.clear();
					continue;
			}
		}
	}
	
	public CustomMemorize makeCustomWord(UserInfomation user) {
		SqlSession session = null;
		CustomMemorize customedWord = null;
		System.out.print("新しい単語を入力してください：");
		String customKanji = sc.nextLine();
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			String check = um.checkDuplicateWord(customKanji);
			session.commit();
			if (check != null) {
				System.out.println("もう登録されている単語です。");
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
		
		
		System.out.print("よみがなを入力してください：");
		String customYomigana = sc.nextLine();
		System.out.print("意味を入力してください：");
		String customMeaning = sc.nextLine();
		customedWord = new CustomMemorize(user.getAccountnumber(), customKanji
									, customYomigana, customMeaning);
		return customedWord;
	}

}
