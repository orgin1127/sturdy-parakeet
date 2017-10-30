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
					System.out.println("관리 시스템을 종료합니다.");
					break;
				case 1:
					printInnerUI();
					int select2 = sc.nextInt();
					sc.nextLine();
					if (amsm.insertInformation(insertVO(select2))) {
						System.out.println("등록성공");
					}
					else {
						System.out.println("등록실패");
					}
					break;
				case 2:
					System.out.print("찾을 동물의 이름을 입력하여 주세요: ");
					String searchName = sc.nextLine();
					System.out.println(amsm.searchAnimal(searchName));
					break;
				case 3:
					System.out.print("수정할 동물의 이름을 입력하여 주세요: ");
					String editAnimalName = sc.nextLine();
					amsm.editAnimal(editAnimalName);
					break;
				case 4:
					System.out.println("─│등록 동물 리스트│─");
					amsm.print();
					break;
				case 5:
					System.out.print("삭제할 동물의 이름을 입력하여 주세요: ");
					String deleteAnimalName = sc.nextLine();
					amsm.delete(deleteAnimalName);
					break;
				default:
					break;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("올바른 메뉴를 선택하여 주세요");
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
				System.out.print("동물 이름: ");
				name = sc.nextLine();
				System.out.print("동물 품종: ");
				specise = sc.nextLine();
				System.out.print("동물 무게: ");
				weight = sc.nextInt();
				sc.nextLine();
				System.out.print("동물 나이: ");
				age = sc.nextInt();
				sc.nextLine();
				System.out.print("동물 주식: ");
				food = sc.nextLine();
				switch (select2) {
					case 1:
						System.out.print("사육사 명: ");
						String zookeeper = sc.nextLine();
						vo = new Zookeeper(name, specise, weight, age, food, zookeeper);
						return vo;
					case 2:
						System.out.print("거주구역: " );
						String cageArea = sc.nextLine();
						vo = new CageArea(name, specise, weight, age, food, cageArea);
						return vo;
					case 3:
						System.out.print("개체수: ");
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
				System.out.println("입력이 잘못되었습니다.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	public void printUI() {
		System.out.println("┌─────────────────────────────┐");
		System.out.println("│         동물원 관리 시스템              │");
		System.out.println("│            1.등록                        │");
		System.out.println("│            2.검색                        │");
		System.out.println("│            3.수정                        │");
		System.out.println("│            4.출력                        │");
		System.out.println("│            5.삭제                        │");
		System.out.println("│            0.종료                        │");
		System.out.println("└─────────────────────────────┘");
		System.out.print("메뉴를 선택하여 주세요 => ");
	}

	
	public void printInnerUI() {
		System.out.println("┌─────────────────────────────┐");
		System.out.println("│         동물원 관리 시스템              │");
		System.out.println("│            1.사육사                     │");
		System.out.println("│            2.거주구역                  │");
		System.out.println("│            3.개체수                     │");
		System.out.println("│            0.상위메뉴                  │");
		System.out.println("└─────────────────────────────┘");
		System.out.print("메뉴를 선택하여 주세요 => ");
	}
}
