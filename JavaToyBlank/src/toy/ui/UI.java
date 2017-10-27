package toy.ui;

import java.util.List;
import java.util.Scanner;

import toy.manager.Manager;
import toy.vo.Bicycle;
import toy.vo.Drone;
import toy.vo.GameConsole;
import toy.vo.Toy;

/**
 * UI를 관리하는 클래스
 */
public class UI {

	private Scanner scanner;
	private Manager manager;

	/**
	 * Constructor
	 */
	public UI() {
		scanner = new Scanner(System.in);
		manager = new Manager();
	}
	
	/**
	 * UI를 시작한다
	 */
	public void start() {
		boolean canContinue = true;
		while(canContinue) {
			int option = printMainMenu();
			
			switch(option) {
				case 1:
					insert();
					break;
				case 2:
					search();
					break;
				case 3:
					delete();
					break;
				case 4:
					print();
					break;
				case 9:
					canContinue = false;
					manager.saveFile();
					break;
				default:
					System.out.println("잘못 입력하셨습니다");
			}
			
			System.out.println();
		}
	}
	
	/**
	 * 메인 메뉴를 표시한다.
	 * @return 메인 메뉴 선택 번호
	 */
	private int printMainMenu() {
		int option = 0;
		
		do {
			System.out.println("===== Toy Manager =====");
			System.out.println("1. 장난감 등록");
			System.out.println("2. 장난감 검색");
			System.out.println("3. 장난감 삭제");
			System.out.println("4. 장난감 정보 출력");
			System.out.println("9. 종료");
			System.out.print("[메뉴 입력]: ");
			
			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("다시 입력해주세요");
				System.out.println();
				scanner.nextLine();
			}
		} while (option == 0);
		
		System.out.println();
		
		return option;
	}
	
	/**
	 * 장난감을 등록한다
	 */
	private void insert() {
		boolean canContinue = true;
		
		while(canContinue) {
			try {
				int option = printInsertMenu();
				if (option == 9) {
					break;
				}
				
				if (option < 1 || 3 < option) {
					System.out.println("잘못 입력하셨습니다");
					continue;
				}
				
				// Toy를 저장할 변수 선언
				Toy t = null;
				
				System.out.print("코드: ");
				String code = scanner.next();
				
				System.out.print("제품명: ");
				String name = scanner.next();
				
				System.out.print("가격: ");
				int price = scanner.nextInt();
				
				if (option == 1) {
					System.out.print("타입: ");
					String type = scanner.next();
					
					t = new Bicycle(code, name, price, type);
				} else if (option == 2) {
					System.out.print("날개 갯수: ");
					int numOfWings = scanner.nextInt();
					
					t = new Drone(code, name, price, numOfWings);
				} else if (option == 3) {
					System.out.print("타입: ");
					String company = scanner.next();
					
					t = new GameConsole(code, name, price, company);
				}
				// 등록 작업
				boolean canInsert = manager.insert(t);
				if (canInsert) {
					System.out.println("등록에 성공했습니다");
				} else {
					System.out.println("등록에 실패했습니다");
				}
			}
			
			catch (Exception e) {
				System.out.println("0-9 숫자를 입력하여 주세요");
				scanner.nextLine();
				continue;
			}
		}
	}
	
	/**
	 * 등록 메뉴를 표시한다
	 */
	private int printInsertMenu() {
		int option = 0;
		
		do {
			System.out.println("===== 장난감 등록 메뉴 =====");
			System.out.println("1. 자전거");
			System.out.println("2. 드론");
			System.out.println("3. 게임기");
			System.out.println("9. 상위메뉴");
			System.out.print("[메뉴 입력]: ");
			
			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("다시 입력해주세요");
				scanner.nextLine();
			}
		} while(option == 0);
		
		System.out.println();
		
		return option;
	}
	
	/**
	 * 장난감을 검색하여 출력한다
	 */
	private void search() {
		System.out.println("===== 장난감 검색 =====");
		System.out.print("장난감 고유 번호: ");
		
		String code = scanner.nextLine();

		System.out.println();
		
		Toy t = manager.search(code);
		
		if (t == null) {
			System.out.println("코드에 해당하는 제품이 존재하지 않습니다");
		} else {
			System.out.println("===== 장난감 정보 =====");	
			System.out.println(t);
		}
	}
	
	/**
	 * 장난감 정보를 삭제한다
	 */
	private void delete() {
		System.out.println("===== 장난감 삭제 =====");
		System.out.print("장난감 고유 번호: ");
		
		String code = scanner.nextLine();
		
		System.out.println();
		
		boolean canDelete = manager.delete(code);
		
		if(canDelete) {
			System.out.println("삭제에 성공하였습니다");
		}
		else {
			System.out.println("삭제에 실패하였습니다");
		}
	}
	
	/**
	 * 전체 장난감 정보를 출력한다
	 */
	private void print() {
		System.out.println("===== 장난감 출력 =====");
		
		List<Toy> list = manager.getToyList();
		
		if (list.isEmpty()) {
			System.out.println("장난감 정보가 한 건도 존재하지 않습니다");
			return;
		}
		
		for (Toy t : list) {
			System.out.println(t);
		}
	}
}
