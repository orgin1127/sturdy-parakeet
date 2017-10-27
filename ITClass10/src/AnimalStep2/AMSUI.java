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
				System.out.println("올바른 메뉴를 선택하여 주세요");
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
		System.out.println("동물이름: ");
		
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
