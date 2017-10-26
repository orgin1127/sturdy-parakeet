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
				System.out.println("�޴��� ���ڸ� �Է��Ͽ� �ּ���");
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
				System.out.println("�޴��� ���ڸ� �Է��Ͽ� �ּ���");
				sc.nextLine();
				continue;
			}
			switch (select2) {
				case 1:
				case 2:
				case 3:
					if (sm.insertHuman(makeHuman(select2))) {
						System.out.println("��Ͽ� �����Ͽ����ϴ�.");
						break;
					}
					else {
						System.out.println("��Ͽ� �����Ͽ����ϴ�. �ٽ� �õ��Ͽ� �ּ���.");
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
				System.out.print("�������� ");
				String inputMajor = sc.nextLine();
				h = new Professor(name, age, jumin, inputMajor);
				break;
			case 2:
				System.out.print("���й��� ");
				String inputStdNo = sc.nextLine();
				h = new Trainee(name, age, jumin, inputStdNo);
				break;
			case 3:
				System.out.print("���μ��� ");
				String inputDepartment = sc.nextLine();
				h = new Staff(name, age, jumin, inputDepartment);
				break;
			default:
				break;
		}
		return h;
	}
	
	public String getNameFromUser() {
		System.out.print("���̸��� ");
		String str = sc.nextLine();
		return str;
	}
	
	public int getAgeFromUser() {
		int i = 0;
		while (true) {
			try {
				System.out.print("�����̦� ");
				i = sc.nextInt();
				sc.nextLine();
				break;
			}
			catch (Exception e) {
				System.out.println("���ڸ� �Է��Ͽ� �ּ���");
				sc.nextLine();
				continue;
			}
		}
		return i;
	}
	
	public String getJuminFromUser() {
		String str = "";
		while (true) {
			System.out.print("���ֹι�ȣ(���� 13�ڸ���,- ����)�� ");
			str = sc.nextLine();
			if (Pattern.matches("^[0-9]*$", str) && str.length() == 13) {
				break;
			}
			else {
				System.out.println("0~9 ���� 13�ڸ��� �Է��Ͽ� �ּ���");
				continue;
			}
		}
		return str;
	}
	
	public void OutterUI() {
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("��      Soft Engineering School �����ý���           ��");
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("");
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.println("��                  1. ���                                      ��");
		System.out.println("��                  2. ã��                                      ��");
		System.out.println("��                  3. ����                                      ��");
		System.out.println("��                  4. ����                                      ��");
		System.out.println("��                  5. ���                                      ��");
		System.out.println("��                  0. ����                                      ��");
		System.out.println("������������������������������������������������������������������������������������������");
		System.out.print("�޴��� �����Ͽ� �ּ��� => ");
	}
	
	public void InnerUI() {
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("��            SES �����ο� ���                         ��");
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("");
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("��                 1.����                                ��");
		System.out.println("��                 2.������                             ��");
		System.out.println("��                 3.���                             ��");
		System.out.println("��                 4.�����޴�                          ��");
		System.out.println("��������������������������������������������������������������������������������");
		System.out.print("�޴��� �����Ͽ� �ּ��� => ");
	}

}
