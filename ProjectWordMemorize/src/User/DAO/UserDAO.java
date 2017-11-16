package User.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import User.DAO.MybatisConfig;
import User.UI2.UICompilation;
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
	
	public void checkUserIsExist() {
		String userID;
		String password;		
		System.out.print("ユ―ザアカウントネーム ：　");
		userID = sc.nextLine();
		System.out.print("暗証番号 ：　");
		password = sc.nextLine();
		UserInfomation user = new UserInfomation(userID, password);
		SqlSession session = null;
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			if (um.checkUser(user) != null) {
				afterLogin();
			}
			else {
				System.out.println("ユ―ザアカウント、または暗証番号が違います。");
				return;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
	}
	
	
	public void afterLogin() {
		HERE:
		while (true) {
			try {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
	
	//		try {
	//			Thread.sleep(1000);
	//		} catch (InterruptedException e) {
	//			e.printStackTrace();
	//		}
			
			ui.afterLoginMenu();
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
							System.out.println("\t"+"\t"+list.get(cnt)+"\t"+"\t");
							System.out.println("");
							System.out.println("");
							System.out.print("다음 단어를 보시겠습니까?(y/n) ");
							String wordViewContinue = sc.nextLine();
							if (wordViewContinue.toLowerCase().equals("y")) {
								cnt++;
							}
							else if (wordViewContinue.toLowerCase().equals("n")) {
								continue HERE;
							}
							else {
								System.out.println("입력이 잘못되었습니다.");
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
							System.out.println(list.get(cnt));
							System.out.print("다음 단어를 보시겠습니까?(y/n) ");
							String wordViewContinue = sc.nextLine();
							if (wordViewContinue.toLowerCase().equals("y")) {
								cnt++;
							}
							else if (wordViewContinue.toLowerCase().equals("n")) {
								continue HERE;
							}
							else {
								System.out.println("입력이 잘못되었습니다.");
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
							System.out.println(list.get(cnt));
							System.out.print("다음 단어를 보시겠습니까?(y/n) ");
							String wordViewContinue = sc.nextLine();
							if (wordViewContinue.toLowerCase().equals("y")) {
								cnt++;
							}
							else if (wordViewContinue.toLowerCase().equals("n")) {
								continue HERE;
							}
							else {
								System.out.println("입력이 잘못되었습니다.");
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
				default:
					System.out.println("올바른 번호를 입력하여 주세요");
					continue;
			}
		}
	}

}
