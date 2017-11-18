package User.DAO;

import java.util.Scanner;
import java.util.regex.Pattern;

import User.UI2.UICompilation;
import User.VO.UserInfomation;

public class BlinkGame {
	Scanner sc = new Scanner(System.in);
	
	public void blinkGameStart(UserInfomation user) {
		printBlinkGameMeni();
		String selectBlinkGameMenu = sc.nextLine();
		
		switch (afterValidCheckNumber(selectBlinkGameMenu)) {
		case 1:
			break;
		case 2:
			break;
		case 99:
			break;
		case 0:
			return;
		}
		
	}

	public void printBlinkGameMeni () {
		System.out.println("1. ゲームスタート");
		System.out.println("2. トップ１０ランキングを見る");
		System.out.println("0. 戻る");
		System.out.print("メニューを選択してください＝＞ ");
	}
	
	public int afterValidCheckNumber(String number) {
		int afterValidCheck = 99;
		if (Pattern.matches("^[0-9]*$", number)) {
			afterValidCheck = Integer.parseInt(number);
			
		}
		else {
			System.err.println("正しい番号を入力してください");
			UICompilation.delay();
			UICompilation.clear();
		}
		return afterValidCheck;
	}
}
