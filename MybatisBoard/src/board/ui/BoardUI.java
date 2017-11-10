package board.ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import board.dao.BoardDAO;
import board.vo.Board;

/**
 * 사용자 화면, 입출력
 */
public class BoardUI {
	
	Scanner sc = new Scanner(System.in);
	BoardDAO dao = new BoardDAO();

	public BoardUI() {
		boolean flag = true;
		while (flag) {
			printMainMenu();
			String select = sc.nextLine();
			if (Pattern.matches("^[0-9]*$", select)) {
				int selectNumber = Integer.parseInt(select);
				//선택한 메뉴 번호에 따라 분기
				switch (selectNumber) {
				//글 쓰기
				case 1:
					writeBoard();
					break;
				//글 전체 목록
				case 2:
					showBoard();
					break;
				//글 읽기
				case 3:
					readBoard();
					break;
				//글 삭제
				case 4:
					deleteBoard();
					break;
				//글 검색
				case 5:
					findBoard();
					break;
				//프로그램 종료
				case 9:
					flag = false;
					System.out.println("프로그램을 종료합니다.");
					sc.close();
					//System.exit(0);
					break;
				//그 외 번호 처리
				default:
					System.out.println("해당 메뉴 번호를 입력하여 주세요.");
					break;
				}
			}
			else {
				System.out.println("숫자를 잘못 입력 하셨습니다.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	public void printMainMenu() {
		System.out.println("[ 게시판 ]");
		System.out.println("1. 글쓰기");
		System.out.println("2. 전체 글 목록");
		System.out.println("3. 글 읽기");
		System.out.println("4. 글 삭제");
		System.out.println("5. 글 검색");
		System.out.println("9. 프로그램 종료");
		System.out.print("번호를 입력해주세요 => ");
	}
	
	public void writeBoard() {
		//이름, 제목, 내용 입력받아 Board객체 생성
		//Board 객체를 BoardDAO의 insertBoard() 메서드로 전달
		//리턴값이 true면 저장 성공, false면 저장 실패
		String name;
		String title;
		String content;
		StringBuffer sb = new StringBuffer();
		
		System.out.print("작성자 이름 입력: ");
		name = sc.nextLine();
		System.out.print("글 제목 입력: ");
		title = sc.nextLine();
		System.out.print("글 내용 입력(종료시에는 엔터를 한번 더 눌러주세요): ");
		while (true) {
			content = sc.nextLine();
			if (content.isEmpty()) {
				break;
			}
			sb.append(content);
			sb.append(content = System.getProperty("line.separator"));
		}
		
		content = sb.toString();
		Board b = new Board(name, title, content);
		
		if (dao.insertBoard(b)) {
			System.out.println("저장성공");
		}
		else {
			System.out.println("저장 실패");
		}
		
	}
	
	public void showBoard() {
		ArrayList<Board> list = dao.showBoard();
		for (Board bb : list) {
			bb.showBoard();
		}
	}
	
	public void readBoard() {
		String str = "";
		int number = 0;
		System.out.print("읽을 글의 번호를 입력하여 주세요 : ");
		str = sc.nextLine();
		if (Pattern.matches("^[0-9]*$", str)) {
			number = Integer.parseInt(str);
		}
		else {
			System.out.println("잘못된 번호 입력");
			sc.nextLine();
			return;
		}
		Board b = dao.readBoard(number);
		b.readBoard();
	}
	
	public void deleteBoard() {
		String str = "";
		int number = 0;
		System.out.print("삭제할 글의 번호를 입력하여 주세요 : ");
		str = sc.nextLine();
		if (Pattern.matches("^[0-9]*$", str)) {
			number = Integer.parseInt(str);
		}
		else {
			System.out.println("잘못된 번호 입력");
			sc.nextLine();
			return;
		}
		if (dao.deleteBoard(number)) {
			System.out.println("삭제 성공");
		}
		else {
			System.out.println("삭제 실패");
		}
	}
	
	public void findBoard() {
		String str = "";
		int number = 0;
		String selectFindMenu = "";
		int intselectFindMenu = 0;
		
		System.out.println("[글 목록 검색]");
		System.out.println("1. 제목으로 검색");
		System.out.println("2. 글 내용으로 검색");
		System.out.println("3. 글 번호로 검색");
		System.out.println("4. 상위메뉴로");
		System.out.print("검색 방법을 선택하여 주세요: ");
		
		selectFindMenu = sc.nextLine();
		
		if (Pattern.matches("^[0-9]*$", selectFindMenu)) {
			intselectFindMenu = Integer.parseInt(selectFindMenu);
			switch (intselectFindMenu) {
			case 1:
				System.out.print("찾을 글의 제목을 입력하여 주세요: ");
				String stringFindTitle = sc.nextLine();
				ArrayList<Board> listForFindTitle = dao.findBoardTitle(stringFindTitle);
				if (listForFindTitle.isEmpty()) {
					System.out.println("검색 결과가 없습니다.");
				}
				else {
					System.out.println(listForFindTitle);
				}
				break;
			case 2:
				System.out.print("찾을 글의 내용을 입력하여 주세요: ");
				String stringFindContent = sc.nextLine();
				break;
			case 3:
				System.out.print("검색할 글의 번호를 입력하여 주세요 : ");
				str = sc.nextLine();
				if (Pattern.matches("^[0-9]*$", str)) {
					number = Integer.parseInt(str);
				}
				else {
					System.out.println("잘못된 번호 입력");
					sc.nextLine();
					return;
				}
				ArrayList<Board> list = dao.findBoardNum(number);
				if (list.isEmpty()) {
					System.out.println("검색 결과가 없습니다.");
				}
				else {
					System.out.println(list);
				}
				break;
			case 4:
				return;

			default:
				break;
			}
		}
		else {
			System.out.println("잘못된 번호 입력");
			sc.nextLine();
			return;
		}
	}

}
