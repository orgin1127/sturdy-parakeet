package User.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import User.DAO.MybatisConfig;
import User.VO.UserInfomation;

public class UserDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	Scanner sc = new Scanner(System.in);
	
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
	
	public String checkUserID(String userID) {
		SqlSession session = null;
		String check = null;
		
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			check = um.checkUserID(userID);
			session.commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		} 
		return check;
	}
	
	public void afterLogin(int i) {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SqlSession session = null;
		ArrayList<Object> list = new ArrayList<>();
		switch (i) {
			case 1:
				try {
					session = factory.openSession();
					UserMapper um = session.getMapper(UserMapper.class);
					list = um.viewWordN1();
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
							return;
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
							return;
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
		}
	}

}
