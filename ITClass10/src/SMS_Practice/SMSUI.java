package SMS_Practice;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SMSUI {
	Scanner sc = new Scanner(System.in);
	SMSManager sm = new SMSManager();
	
	boolean flag = true;
	int select = 0;
	int select2 = 0;
	public void SMS_UI() {
		while (flag) {
			OutterUI();
			try {
				select = sc.nextInt();
				sc.nextLine();
			}
			catch (Exception e) {
				System.out.println("메뉴의 숫자를 입력하여 주세요");
				sc.nextLine();
				continue;
			}
		
			switch (select) {
				case 0:
					flag = false;
					break;
				case 1:
					InnerUI();
					insertHuman();
					break;
				case 2:
					System.out.println(sm.findHuman(getJuminFromUser()));
					break;
				case 3:
					sm.editHuman(getJuminFromUser());
					break;
				case 4: 
					sm.deleteHuman(getJuminFromUser());
					break;
				case 5:
					sm.showAll();
					break;
				default:
					break;
			}
		}
	}
	
	public void insertHuman() {
		while (true) {
			try {
				select2 = sc.nextInt();
				sc.nextLine();
			}
			catch (Exception e) {
				System.out.println("메뉴의 숫자를 입력하여 주세요");
				sc.nextLine();
				continue;
			}
			switch (select2) {
				case 1:
				case 2:
				case 3:
					if (sm.insertHuman(makeHuman(select2))) {
						System.out.println("등록에 성공하였습니다.");
						break;
					}
					else {
						System.out.println("등록에 실패하였습니다. 다시 시도하여 주세요.");
						break;
					}
				case 4:
					return;
				default:
					break;
			}
			break;
		}
	}
	
	public Human makeHuman (int i) {
		Human h = null;
		String name = getNameFromUser();
		int age = getAgeFromUser();
		String jumin = getJuminFromUser();
		
		switch (i) {
			case 1:
				System.out.print("│전공│ ");
				String inputMajor = sc.nextLine();
				h = new Professor(name, age, jumin, inputMajor);
				break;
			case 2:
				System.out.print("│학번│ ");
				String inputStdNo = sc.nextLine();
				h = new Trainee(name, age, jumin, inputStdNo);
				break;
			case 3:
				System.out.print("│부서│ ");
				String inputDepartment = sc.nextLine();
				h = new Staff(name, age, jumin, inputDepartment);
				break;
			default:
				break;
		}
		return h;
	}
	
	public String getNameFromUser() {
		System.out.print("│이름│ ");
		String str = sc.nextLine();
		return str;
	}
	
	public int getAgeFromUser() {
		int i = 0;
		while (true) {
			try {
				System.out.print("│나이│ ");
				i = sc.nextInt();
				sc.nextLine();
				break;
			}
			catch (Exception e) {
				System.out.println("숫자를 입력하여 주세요");
				sc.nextLine();
				continue;
			}
		}
		return i;
	}
	
	public String getJuminFromUser() {
		String str = "";
		while (true) {
			System.out.print("│주민번호(숫자 13자리만,- 제외)│ ");
			str = sc.nextLine();
			if (Pattern.matches("^[0-9]*$", str) && str.length() == 13) {
				break;
			}
			else {
				System.out.println("0~9 숫자 13자리를 입력하여 주세요");
				continue;
			}
		}
		return str;
	}
	
	public void OutterUI() {
		System.out.println("┌───────────────────────────────────────────┐");
		System.out.println("│      Soft Engineering School 관리시스템           │");
		System.out.println("└───────────────────────────────────────────┘");
		System.out.println("");
		System.out.println("┌───────────────────────────────────────────┐");
		System.out.println("│                  1. 등록                                      │");
		System.out.println("│                  2. 찾기                                      │");
		System.out.println("│                  3. 수정                                      │");
		System.out.println("│                  4. 삭제                                      │");
		System.out.println("│                  5. 출력                                      │");
		System.out.println("│                  0. 종료                                      │");
		System.out.println("└───────────────────────────────────────────┘");
		System.out.print("메뉴를 선택하여 주세요 => ");
	}
	
	public void InnerUI() {
		System.out.println("┌──────────────────────────────────────┐");
		System.out.println("│            SES 관리인원 등록                         │");
		System.out.println("└──────────────────────────────────────┘");
		System.out.println("");
		System.out.println("┌──────────────────────────────────────┐");
		System.out.println("│                 1.교수                                │");
		System.out.println("│                 2.연수생                             │");
		System.out.println("│                 3.운영진                             │");
		System.out.println("│                 4.상위메뉴                          │");
		System.out.println("└──────────────────────────────────────┘");
		System.out.print("메뉴를 선택하여 주세요 => ");
	}

}
