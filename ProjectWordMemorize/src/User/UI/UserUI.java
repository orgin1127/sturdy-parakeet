package User.UI;

import java.util.Scanner;

import java.util.TimerTask;
import java.util.regex.Pattern;

import User.DAO.UserDAO;
import User.UI2.UICompilation;
import User.VO.UserInfomation;

public class UserUI {
	Scanner sc = new Scanner(System.in);
	UserDAO dao = new UserDAO();
	UICompilation ui = new UICompilation();

	public UserUI() {
		while (true) {
			UICompilation.clear();
			ui.startMenu();
			String selectMainMenu = sc.nextLine();
			switch (checkNumberValidity(selectMainMenu)) {
			case 1: 
				UICompilation.clear();
				registUser();
				break;
			case 2:
				login();
				break;
			case 9:
				return;
			case 0:
				System.err.println("[お知らせ]　プログラムを終了します。");
				return;
			default:
				System.err.println("[お知らせ] 正しいメニュ―を選択して下さい");
				UICompilation.delay();
				break;
			}
		}
	}
	
	public void registUser() {
		ui.joinMemberMenu();
		String userID;
		String password;		
		System.out.print("ユ―ザアカウントネーム ：　");
		userID = sc.nextLine();
		if(dao.checkUserID(userID) == null) {
			System.out.print("暗証番号 ：　");
			password = sc.nextLine();
			UserInfomation userInfo = new UserInfomation(userID, password);
			if(dao.insertUser(userInfo)) {
				
				System.out.println("登録されました。");
				UICompilation.delay();
			}
			else {
				System.err.println("登録に失敗しました。");
				UICompilation.delay();
			}
			
			return;
		}
		else {
			
			System.err.println("重腹したIDがあります。");
			UICompilation.delay();
			return;
		}		
		
	}
	
	//Login method, 이미 등록된 유저인지 확인하여 있으면 해당 객체를 가져와 사용한다.
	public void login() {
		String userID;
		String password;		
		System.out.print("ユ―ザアカウントネーム ：　");
		userID = sc.nextLine();
		System.out.print("暗証番号 ：　");
		password = sc.nextLine();
		UserInfomation user = dao.checkUserIsExist(userID, password);
		if (user != null) {
			UICompilation.clear();
			dao.afterLogin(user);
		}
	}
	
	//String으로 받은 문자열 안에 숫자만 존재하는지를 정규식을 통하여 검사하는 Method
	public int checkNumberValidity(String select) {
		int selectedMenu = 99;
		if (Pattern.matches("^[0-9]*$", select)) {
			selectedMenu = Integer.parseInt(select);
			return selectedMenu;
		}
		else {
			return selectedMenu;
		}
	}


}
