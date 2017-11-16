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
	
	public void printLoginUI() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("==========[로그인 성공]==========");
		System.out.println("");
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("1. 単語を見る");
		System.out.println("2. ");
		String selectLoginMenu = sc.nextLine();
		int loginMenu = 0;
		if (Pattern.matches("^[0-9]*$", selectLoginMenu)) {
			loginMenu = Integer.parseInt(selectLoginMenu);
		}
		switch (loginMenu) {
		case 1:
			SqlSession session = null;
			ArrayList<Object> list = new ArrayList<>();
			try {
				session = factory.openSession();
				UserMapper um = session.getMapper(UserMapper.class);
				list = um.viewWordN1();
				Collections.shuffle(list);
				session.commit();
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
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
