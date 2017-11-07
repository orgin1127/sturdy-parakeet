package SES;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SESUI {
	Scanner sc = new Scanner(System.in);
	public SESUI() {
		
		boolean flag = true;
		
		while (flag) {
			printMainMenu();
			try {
				int select1 = sc.nextInt();
				sc.nextLine();
				switch (select1) {
					case 1:
						
					case 2:
					case 3:
					case 4:
					case 5:
					case 0:
						flag = false;
						break;
				}
			}
			catch (Exception e) {
				System.out.println("숫자를 입력하여 주세요");
				sc.nextLine();
				continue;
			}
			
			
		}
		
	}
	
	public void printMainMenu() {
		System.out.println("Soft Engineering School 관리시스템");
		System.out.println("");
		System.out.println("1. 등록");
		System.out.println("2. 찾기");
		System.out.println("3. 삭제");
		System.out.println("4. 수정");
		System.out.println("5. 전체출력");
		System.out.println("0. 종료");
		System.out.print("메뉴를 선택해주세요 => ");
	}
	
	public void printInsertMenu() {
		System.out.println("Soft Engineering School 관리인원 등록");
		System.out.println("");
		System.out.println("1. 교수");
		System.out.println("2. 연수생");
		System.out.println("3. 운영진");
		System.out.println("4. 상위메뉴");
		System.out.print("메뉴를 선택해주세요 => ");
	}

	public void insertHuman() {
		boolean insertFlag = true;
		int select2 = 0;
		while(insertFlag) {
			printInsertMenu();
			try {
				select2 = sc.nextInt();
				sc.nextLine();
			}
			catch (Exception e) {
				System.out.println("올바른 번호를 선택하여 주세요.");
				continue;
			}
			switch(select2) {
				case 1:
				case 2:
				case 3:
					makeHuman(select2);
					break;
				case 4:
					insertFlag = false;
					break;
				default:
					continue;
			}
		}
	}
	
	public Human makeHuman(int select2) {
		Human makeHuman = null;
		String name = getNameFromUser();
		int age = getAgeFromUser();
		String jumin = getJuminFromUser();
		
		switch (select2) {
			case 1:
				System.out.print("│전공│ ");
				String major = sc.nextLine();
				makeHuman = new Professor(name, age, jumin, major);
				break;
			case 2:
				System.out.print("│학번│ ");
				String stdNo = sc.nextLine();
				makeHuman = new Trainee(name, age, jumin, stdNo);
				break;
			case 3:
				System.out.print("│부서│ ");
				String field = sc.nextLine();
				makeHuman = new Staff(name, age, jumin, field);
				break;
		}
		return makeHuman;
	}
	
	public String getNameFromUser() {
		System.out.print("│이름│ ");
		String name = sc.nextLine();
		return name;
	}
	
	public int getAgeFromUser() {
		int age = 0;
		while (true) {
			try {
				System.out.print("│나이│ ");
				age = sc.nextInt();
				sc.nextLine();
				break;
			}
			catch (Exception e) {
				System.out.println("올바른 숫자를 입력하여 주십시오.");
				sc.nextLine();
				break;
			}
		}
		return age;
	}
	
	public String getJuminFromUser() {
		String jumin = "";
		while (true) {
			System.out.print("│주민번호(13자리, 숫자만)│ ");
			jumin = sc.nextLine();
			if (Pattern.matches("^|0-9|*%", jumin) && jumin.length()==13) {
				return jumin;
			}
			else {
				System.out.println("올바른 주민번호를 입력하여 주십시오.");
				continue;
			}
		}
	}
}
