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
				System.out.println("���ڸ� �Է��Ͽ� �ּ���");
				sc.nextLine();
				continue;
			}
			
			
		}
		
	}
	
	public void printMainMenu() {
		System.out.println("Soft Engineering School �����ý���");
		System.out.println("");
		System.out.println("1. ���");
		System.out.println("2. ã��");
		System.out.println("3. ����");
		System.out.println("4. ����");
		System.out.println("5. ��ü���");
		System.out.println("0. ����");
		System.out.print("�޴��� �������ּ��� => ");
	}
	
	public void printInsertMenu() {
		System.out.println("Soft Engineering School �����ο� ���");
		System.out.println("");
		System.out.println("1. ����");
		System.out.println("2. ������");
		System.out.println("3. ���");
		System.out.println("4. �����޴�");
		System.out.print("�޴��� �������ּ��� => ");
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
				System.out.println("�ùٸ� ��ȣ�� �����Ͽ� �ּ���.");
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
				System.out.print("�������� ");
				String major = sc.nextLine();
				makeHuman = new Professor(name, age, jumin, major);
				break;
			case 2:
				System.out.print("���й��� ");
				String stdNo = sc.nextLine();
				makeHuman = new Trainee(name, age, jumin, stdNo);
				break;
			case 3:
				System.out.print("���μ��� ");
				String field = sc.nextLine();
				makeHuman = new Staff(name, age, jumin, field);
				break;
		}
		return makeHuman;
	}
	
	public String getNameFromUser() {
		System.out.print("���̸��� ");
		String name = sc.nextLine();
		return name;
	}
	
	public int getAgeFromUser() {
		int age = 0;
		while (true) {
			try {
				System.out.print("�����̦� ");
				age = sc.nextInt();
				sc.nextLine();
				break;
			}
			catch (Exception e) {
				System.out.println("�ùٸ� ���ڸ� �Է��Ͽ� �ֽʽÿ�.");
				sc.nextLine();
				break;
			}
		}
		return age;
	}
	
	public String getJuminFromUser() {
		String jumin = "";
		while (true) {
			System.out.print("���ֹι�ȣ(13�ڸ�, ���ڸ�)�� ");
			jumin = sc.nextLine();
			if (Pattern.matches("^|0-9|*%", jumin) && jumin.length()==13) {
				return jumin;
			}
			else {
				System.out.println("�ùٸ� �ֹι�ȣ�� �Է��Ͽ� �ֽʽÿ�.");
				continue;
			}
		}
	}
}
