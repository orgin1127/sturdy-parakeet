package AnimalStep2;

import java.util.Scanner;

public class AMSUI {
	Scanner sc = new Scanner(System.in);

	public void amsUI() {
		boolean flag = true;
		while (flag) {
			printUI();
			try {
				int select = sc.nextInt();
				switch (select) {
				case 1:
					printInnerUI();
					int select2 = sc.nextInt();
					
					break;
				default:
					break;
				}
			}
			catch (Exception e) {
				System.out.println("�ùٸ� �޴��� �����Ͽ� �ּ���");
				sc.nextLine();
				continue;
			}
		}
	}
	
	public VO insertVO(int select2) {
		private String name;
		private String specise;
		private int weight;
		private int age;
		private String food;
		System.out.println("�����̸�: ");
		
	}
	
	public void printUI() {
		System.out.println("��������������������������������������������������������������");
		System.out.println("��         ������ ���� �ý���              ��");
		System.out.println("��            1.���                        ��");
		System.out.println("��            2.�˻�                        ��");
		System.out.println("��            3.����                        ��");
		System.out.println("��            4.���                        ��");
		System.out.println("��            5.����                        ��");
		System.out.println("��            0.����                        ��");
		System.out.println("��������������������������������������������������������������");
		System.out.print("�޴��� �����Ͽ� �ּ��� => ");
	}

	
	public void printInnerUI() {
		System.out.println("��������������������������������������������������������������");
		System.out.println("��         ������ ���� �ý���              ��");
		System.out.println("��            1.������                     ��");
		System.out.println("��            2.���ֱ���                  ��");
		System.out.println("��            3.��ü��                     ��");
		System.out.println("��            0.�����޴�                  ��");
		System.out.println("��������������������������������������������������������������");
		System.out.print("�޴��� �����Ͽ� �ּ��� => ");
	}
}
