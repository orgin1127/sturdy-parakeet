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
		case 1: registUser();
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
		System.out.print("==> ");
	}

	public void registUser() {
		String userID;
		String password;		
		System.out.print("ユ―ザアカウントネーム ：　");
		userID = sc.nextLine();
		if(dao.checkUserID(userID) == null) {
			System.out.print("暗証番号 ：　");
			password = sc.nextLine();
			UserInfomation userInfo = new UserInfomation(userID, password);
			if(dao.insertUser(userInfo)) {
				System.out.println("등록되었습니다.");
			}
			else {
				System.err.println("등록에 실패하였습니다.");
			}
			
			return;
		}
		else {
			System.err.println("重腹したIDがあります。");
			return;
		}		
		
	}
	
	//String으로 받은 문자열 안에 숫자만 존재하는지를 정규식을 통하여 검사하는 Method
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
