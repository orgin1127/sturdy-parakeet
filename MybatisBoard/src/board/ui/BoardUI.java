package board.ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import board.dao.BoardDAO;
import board.vo.Board;
import board.vo.Reply;

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
				System.out.println("");
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
		if (b==null) {
			System.out.println("글이 존재하지 않습니다");
		}
		else {
			b.readBoard();
		}
		
		//현재 글에 달린 리플들 검색해서 출력
		ArrayList<Reply> list = dao.findReply(number);
		for (Reply showReply : list) {
			showReply.showReply();
		}
		System.out.println("");
		//이 글에 리플을 달 것인지 선택
		while (true) {
			System.out.print("이 글에 리플을 작성하시겠습니까? (Y/N) => ");
			String select = sc.nextLine();
			if (select.toLowerCase().equals("n")) {
				return;
			}
			//리플 입력하여 DB에 저장
			else if (select.toLowerCase().equals("y")) {
				String replyWriter;
				String replyText;
				StringBuffer sb = new StringBuffer();
				System.out.print("리플 작성자: ");
				replyWriter = sc.nextLine();
				System.out.print("리플 내용 입력(종료시에는 엔터를 한번 더 눌러주세요): ");
				while (true) {
					replyText = sc.nextLine();
					if (replyText.isEmpty()) {
						break;
					}
					sb.append(replyText);
					sb.append(replyText = System.getProperty("line.separator"));
				}
				replyText = sb.toString();
				Reply reply = new Reply(number, replyWriter, replyText);
				if (dao.writeReply(reply)) {
					System.out.println("등록성공");
					return;
				}
				else {
					System.err.println("등록실패");
					return;
				}
			}
			else {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
		}
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
		String selectFindMenu = "";
		int intselectFindMenu = 0;
		String findWord = "";
		
		System.out.println("[글 목록 검색]");
		System.out.println("1. 제목으로 검색");
		System.out.println("2. 글 내용으로 검색");
		System.out.println("3. 작성자로 검색");
		System.out.println("4. 전체");
		System.out.println("0. 상위메뉴로");
		System.out.print("검색 방법을 선택하여 주세요: ");
		selectFindMenu = sc.nextLine();
		
		if (Pattern.matches("^[0-9]*$", selectFindMenu)) {
			intselectFindMenu = Integer.parseInt(selectFindMenu);
			switch(intselectFindMenu) {
			case 1:
				System.out.print("찾을 글의 제목을 입력하여 주세요: ");
				findWord = sc.nextLine();
				ArrayList<Board> listForFindTitle = dao.findBoard(intselectFindMenu, findWord);
				for (Board boardForShow : listForFindTitle) {
					boardForShow.showBoard();
				}
				break;
			case 2:
				System.out.print("찾을 글의 내용을 입력하여 주세요: ");
				findWord = sc.nextLine();
				ArrayList<Board> listForFindContent = dao.findBoard(intselectFindMenu, findWord);
				for (Board boardForShow : listForFindContent) {
					boardForShow.showBoard();
				}
				break;
			case 3:
				System.out.print("찾을 글의 작성자를 입력하여 주세요: ");
				findWord = sc.nextLine();
				ArrayList<Board> listForFindWriter = dao.findBoard(intselectFindMenu, findWord);
				for (Board boardForShow : listForFindWriter) {
					boardForShow.showBoard();
				}
				break;
			case 4:
				System.out.println("찾을 글의 키워드를 입력하여 주세요: ");
				findWord = sc.nextLine();
				ArrayList<Board> listForFindKeyword = dao.findBoard(intselectFindMenu, findWord);
				for (Board boardForShow : listForFindKeyword) {
					boardForShow.showBoard();
				}
			case 0:
				return;
			default:
				break;
			}
		}
		else {
			System.out.println("잘못된 번호를 선택하셨습니다.");
			return;
		}
		
		
		//동적sql 쓰기 전 아까워라 내 코드
//		if (Pattern.matches("^[0-9]*$", selectFindMenu)) {
//			intselectFindMenu = Integer.parseInt(selectFindMenu);
//			switch (intselectFindMenu) {
//			case 1:
//				System.out.print("찾을 글의 제목을 입력하여 주세요: ");
//				String stringFindTitle = sc.nextLine();
//				ArrayList<Board> listForFindTitle = dao.findBoardTitle(stringFindTitle);
//				if (listForFindTitle.isEmpty()) {
//					System.err.println("[오류] 검색 결과가 없습니다.");
//				}
//				else {
//					for (Board boardForShowSearchResult : listForFindTitle) {
//						boardForShowSearchResult.showBoard();
//					}
//					
//				}
//				System.out.println("");
//				break;
//			case 2:
//				System.out.print("찾을 글의 내용을 입력하여 주세요: ");
//				String stringFindContent = sc.nextLine();
//				ArrayList<Board> listForFindContent = dao.findBoardContent(stringFindContent);
//				if (listForFindContent.isEmpty()) {
//					System.err.println("[오류] 검색 결과가 없습니다.");
//				}
//				else {
//					for (Board boardForShowSearchResult : listForFindContent) {
//						boardForShowSearchResult.showBoard();
//					}
//				}
//				System.out.println("");
//				break;
//			case 3:
//				System.out.print("검색할 글의 번호를 입력하여 주세요 : ");
//				str = sc.nextLine();
//				if (Pattern.matches("^[0-9]*$", str)) {
//					number = Integer.parseInt(str);
//				}
//				else {
//					System.out.println("잘못된 번호 입력");
//					sc.nextLine();
//					System.out.println("");
//					return;
//				}
//				ArrayList<Board> listForFindNum = dao.findBoardNum(number);
//				if (listForFindNum.isEmpty()) {
//					System.err.println("[오류] 검색 결과가 없습니다.");
//				}
//				else {
//					for (Board boardForShowSearchResult : listForFindNum) {
//						boardForShowSearchResult.showBoard();
//					}
//				}
//				System.out.println("");
//				break;
//			case 4:
//				System.out.println("검색할 작성자를 입력하여 주세요 : ");
//				String stringFindWriter = sc.nextLine();
//				ArrayList<Board> findForShowSearchResult = dao.findBoardWriter(stringFindWriter);
//				break;
//			case 5:
//				return;
//
//			default:
//				break;
//			}
//		}
//		else {
//			System.out.println("잘못된 번호 입력");
//			System.out.println("");
//			return;
//		}
	}

}
