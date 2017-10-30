package AnimalStep2;

import java.util.Scanner;

public class AMSUI {
	Scanner sc = new Scanner(System.in);
	VO vo = null;
	AMSManager amsm = new AMSManager();
	
	public void amsUI() {
		boolean flag = true;
		while (flag) {
			printUI();
			try {
				int select = sc.nextInt();
				sc.nextLine();
				switch (select) {
				case 0:
					amsm.setFile();
					flag = false;
					System.out.println("���� �ý����� �����մϴ�.");
					break;
				case 1:
					printInnerUI();
					int select2 = sc.nextInt();
					sc.nextLine();
					if (amsm.insertInformation(insertVO(select2))) {
						System.out.println("��ϼ���");
					}
					else {
						System.out.println("��Ͻ���");
					}
					break;
				case 2:
					System.out.print("ã�� ������ �̸��� �Է��Ͽ� �ּ���: ");
					String searchName = sc.nextLine();
					System.out.println(amsm.searchAnimal(searchName));
					break;
				case 3:
					System.out.print("������ ������ �̸��� �Է��Ͽ� �ּ���: ");
					String editAnimalName = sc.nextLine();
					amsm.editAnimal(editAnimalName);
					break;
				case 4:
					System.out.println("������� ���� ����Ʈ����");
					amsm.print();
					break;
				case 5:
					System.out.print("������ ������ �̸��� �Է��Ͽ� �ּ���: ");
					String deleteAnimalName = sc.nextLine();
					amsm.delete(deleteAnimalName);
					break;
				default:
					break;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("�ùٸ� �޴��� �����Ͽ� �ּ���");
				sc.nextLine();
				continue;
			}
		}
	}
	
	public VO insertVO(int select2) {
		String name;
		String specise;
		int weight;
		int age;
		String food;
		while (true) {
			try {
				System.out.print("���� �̸�: ");
				name = sc.nextLine();
				System.out.print("���� ǰ��: ");
				specise = sc.nextLine();
				System.out.print("���� ����: ");
				weight = sc.nextInt();
				sc.nextLine();
				System.out.print("���� ����: ");
				age = sc.nextInt();
				sc.nextLine();
				System.out.print("���� �ֽ�: ");
				food = sc.nextLine();
				switch (select2) {
					case 1:
						System.out.print("������ ��: ");
						String zookeeper = sc.nextLine();
						vo = new Zookeeper(name, specise, weight, age, food, zookeeper);
						return vo;
					case 2:
						System.out.print("���ֱ���: " );
						String cageArea = sc.nextLine();
						vo = new CageArea(name, specise, weight, age, food, cageArea);
						return vo;
					case 3:
						System.out.print("��ü��: ");
						int population = sc.nextInt();
						vo = new Population(name, specise, weight, age, food, population);
						return vo;
					case 0:
						return null;
					default:
						break;
				}
			}
			catch (Exception e) {
				System.out.println("�Է��� �߸��Ǿ����ϴ�.");
				sc.nextLine();
				continue;
			}
		}
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
