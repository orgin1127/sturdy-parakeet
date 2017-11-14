package board.ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import board.dao.BoardDAO;
import board.vo.Board;
import board.vo.Reply;

/**
 * ����� ȭ��, �����
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
				//������ �޴� ��ȣ�� ���� �б�
				switch (selectNumber) {
				//�� ����
				case 1:
					writeBoard();
					break;
				//�� ��ü ���
				case 2:
					showBoard();
					break;
				//�� �б�
				case 3:
					readBoard();
					break;
				//�� ����
				case 4:
					deleteBoard();
					break;
				//�� �˻�
				case 5:
					findBoard();
					break;
				//���α׷� ����
				case 9:
					flag = false;
					System.out.println("���α׷��� �����մϴ�.");
					sc.close();
					//System.exit(0);
					break;
				//�� �� ��ȣ ó��
				default:
					System.out.println("�ش� �޴� ��ȣ�� �Է��Ͽ� �ּ���.");
					break;
				}
			}
			else {
				System.out.println("���ڸ� �߸� �Է� �ϼ̽��ϴ�.");
				System.out.println("");
				continue;
			}
		}
	}
	
	public void printMainMenu() {
		System.out.println("[ �Խ��� ]");
		System.out.println("1. �۾���");
		System.out.println("2. ��ü �� ���");
		System.out.println("3. �� �б�");
		System.out.println("4. �� ����");
		System.out.println("5. �� �˻�");
		System.out.println("9. ���α׷� ����");
		System.out.print("��ȣ�� �Է����ּ��� => ");
	}
	
	public void writeBoard() {
		//�̸�, ����, ���� �Է¹޾� Board��ü ����
		//Board ��ü�� BoardDAO�� insertBoard() �޼���� ����
		//���ϰ��� true�� ���� ����, false�� ���� ����
		String name;
		String title;
		String content;
		StringBuffer sb = new StringBuffer();
		
		System.out.print("�ۼ��� �̸� �Է�: ");
		name = sc.nextLine();
		System.out.print("�� ���� �Է�: ");
		title = sc.nextLine();
		System.out.print("�� ���� �Է�(����ÿ��� ���͸� �ѹ� �� �����ּ���): ");
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
			System.out.println("���强��");
		}
		else {
			System.out.println("���� ����");
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
		System.out.print("���� ���� ��ȣ�� �Է��Ͽ� �ּ��� : ");
		str = sc.nextLine();
		if (Pattern.matches("^[0-9]*$", str)) {
			number = Integer.parseInt(str);
		}
		else {
			System.out.println("�߸��� ��ȣ �Է�");
			sc.nextLine();
			return;
		}
		Board b = dao.readBoard(number);
		if (b==null) {
			System.out.println("���� �������� �ʽ��ϴ�");
		}
		else {
			b.readBoard();
		}
		
		//���� �ۿ� �޸� ���õ� �˻��ؼ� ���
		ArrayList<Reply> list = dao.findReply(number);
		for (Reply showReply : list) {
			showReply.showReply();
		}
		System.out.println("");
		//�� �ۿ� ������ �� ������ ����
		while (true) {
			System.out.print("�� �ۿ� ������ �ۼ��Ͻðڽ��ϱ�? (Y/N) => ");
			String select = sc.nextLine();
			if (select.toLowerCase().equals("n")) {
				return;
			}
			//���� �Է��Ͽ� DB�� ����
			else if (select.toLowerCase().equals("y")) {
				String replyWriter;
				String replyText;
				StringBuffer sb = new StringBuffer();
				System.out.print("���� �ۼ���: ");
				replyWriter = sc.nextLine();
				System.out.print("���� ���� �Է�(����ÿ��� ���͸� �ѹ� �� �����ּ���): ");
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
					System.out.println("��ϼ���");
					return;
				}
				else {
					System.err.println("��Ͻ���");
					return;
				}
			}
			else {
				System.out.println("�߸��� �Է��Դϴ�.");
				continue;
			}
		}
	}
	
	public void deleteBoard() {
		String str = "";
		int number = 0;
		System.out.print("������ ���� ��ȣ�� �Է��Ͽ� �ּ��� : ");
		str = sc.nextLine();
		if (Pattern.matches("^[0-9]*$", str)) {
			number = Integer.parseInt(str);
		}
		else {
			System.out.println("�߸��� ��ȣ �Է�");
			sc.nextLine();
			return;
		}
		if (dao.deleteBoard(number)) {
			System.out.println("���� ����");
		}
		else {
			System.out.println("���� ����");
		}
	}
	
	public void findBoard() {
		String selectFindMenu = "";
		int intselectFindMenu = 0;
		String findWord = "";
		
		System.out.println("[�� ��� �˻�]");
		System.out.println("1. �������� �˻�");
		System.out.println("2. �� �������� �˻�");
		System.out.println("3. �ۼ��ڷ� �˻�");
		System.out.println("4. ��ü");
		System.out.println("0. �����޴���");
		System.out.print("�˻� ����� �����Ͽ� �ּ���: ");
		selectFindMenu = sc.nextLine();
		
		if (Pattern.matches("^[0-9]*$", selectFindMenu)) {
			intselectFindMenu = Integer.parseInt(selectFindMenu);
			switch(intselectFindMenu) {
			case 1:
				System.out.print("ã�� ���� ������ �Է��Ͽ� �ּ���: ");
				findWord = sc.nextLine();
				ArrayList<Board> listForFindTitle = dao.findBoard(intselectFindMenu, findWord);
				for (Board boardForShow : listForFindTitle) {
					boardForShow.showBoard();
				}
				break;
			case 2:
				System.out.print("ã�� ���� ������ �Է��Ͽ� �ּ���: ");
				findWord = sc.nextLine();
				ArrayList<Board> listForFindContent = dao.findBoard(intselectFindMenu, findWord);
				for (Board boardForShow : listForFindContent) {
					boardForShow.showBoard();
				}
				break;
			case 3:
				System.out.print("ã�� ���� �ۼ��ڸ� �Է��Ͽ� �ּ���: ");
				findWord = sc.nextLine();
				ArrayList<Board> listForFindWriter = dao.findBoard(intselectFindMenu, findWord);
				for (Board boardForShow : listForFindWriter) {
					boardForShow.showBoard();
				}
				break;
			case 4:
				System.out.println("ã�� ���� Ű���带 �Է��Ͽ� �ּ���: ");
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
			System.out.println("�߸��� ��ȣ�� �����ϼ̽��ϴ�.");
			return;
		}
		
		
		//����sql ���� �� �Ʊ���� �� �ڵ�
//		if (Pattern.matches("^[0-9]*$", selectFindMenu)) {
//			intselectFindMenu = Integer.parseInt(selectFindMenu);
//			switch (intselectFindMenu) {
//			case 1:
//				System.out.print("ã�� ���� ������ �Է��Ͽ� �ּ���: ");
//				String stringFindTitle = sc.nextLine();
//				ArrayList<Board> listForFindTitle = dao.findBoardTitle(stringFindTitle);
//				if (listForFindTitle.isEmpty()) {
//					System.err.println("[����] �˻� ����� �����ϴ�.");
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
//				System.out.print("ã�� ���� ������ �Է��Ͽ� �ּ���: ");
//				String stringFindContent = sc.nextLine();
//				ArrayList<Board> listForFindContent = dao.findBoardContent(stringFindContent);
//				if (listForFindContent.isEmpty()) {
//					System.err.println("[����] �˻� ����� �����ϴ�.");
//				}
//				else {
//					for (Board boardForShowSearchResult : listForFindContent) {
//						boardForShowSearchResult.showBoard();
//					}
//				}
//				System.out.println("");
//				break;
//			case 3:
//				System.out.print("�˻��� ���� ��ȣ�� �Է��Ͽ� �ּ��� : ");
//				str = sc.nextLine();
//				if (Pattern.matches("^[0-9]*$", str)) {
//					number = Integer.parseInt(str);
//				}
//				else {
//					System.out.println("�߸��� ��ȣ �Է�");
//					sc.nextLine();
//					System.out.println("");
//					return;
//				}
//				ArrayList<Board> listForFindNum = dao.findBoardNum(number);
//				if (listForFindNum.isEmpty()) {
//					System.err.println("[����] �˻� ����� �����ϴ�.");
//				}
//				else {
//					for (Board boardForShowSearchResult : listForFindNum) {
//						boardForShowSearchResult.showBoard();
//					}
//				}
//				System.out.println("");
//				break;
//			case 4:
//				System.out.println("�˻��� �ۼ��ڸ� �Է��Ͽ� �ּ��� : ");
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
//			System.out.println("�߸��� ��ȣ �Է�");
//			System.out.println("");
//			return;
//		}
	}

}
