package User.UI;

import java.util.Scanner;
import java.util.regex.Pattern;

import User.DAO.UserDAO;
import User.VO.UserInfomation;

public class UserUI {
	Scanner sc = new Scanner(System.in);
	UserDAO dao = new UserDAO();
	public UserUI() {
		printMainUI();
		String selectMainMenu = sc.nextLine();
		switch (checkNumberValidity(selectMainMenu)) {
		case 1:
			
			break;
		case 2:
			break;
		case 0:
			System.out.println("正しいメニュ―を選択して下さい");
			break;
		default:
			System.out.println("正しいメニュ―を選択して下さい");
			break;
		}
	}
	
	public void printMainUI() {
		System.out.println("*****************************************");
		System.out.println("*********	Word Memorize	*********");
		System.out.println("*****************************************");
		System.out.println(" ");
		System.out.println("============メニューを選択して下さい============");
		System.out.println("1. アカウント登録");
		System.out.println("2. ログイン");
		System.out.print("==>");
	}

	public UserInfomation registUser() {
		String account;
		String password;
		System.out.print("ユ―ザアカウントネーム：　");
		
	}
	
	public int checkNumberValidity(String select) {
		int selectedMenu = 0;
		if (Pattern.matches("^[0-9]*$", select)) {
			selectedMenu = Integer.parseInt(select);
			return selectedMenu;
		}
		else {
			return selectedMenu;
		}
	}
}
