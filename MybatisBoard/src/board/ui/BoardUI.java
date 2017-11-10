package board.ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import board.dao.BoardDAO;
import board.vo.Board;

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
				sc.nextLine();
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
		b.readBoard();
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
		String str = "";
		int number = 0;
		String selectFindMenu = "";
		int intselectFindMenu = 0;
		
		System.out.println("[�� ��� �˻�]");
		System.out.println("1. �������� �˻�");
		System.out.println("2. �� �������� �˻�");
		System.out.println("3. �� ��ȣ�� �˻�");
		System.out.println("4. �����޴���");
		System.out.print("�˻� ����� �����Ͽ� �ּ���: ");
		
		selectFindMenu = sc.nextLine();
		
		if (Pattern.matches("^[0-9]*$", selectFindMenu)) {
			intselectFindMenu = Integer.parseInt(selectFindMenu);
			switch (intselectFindMenu) {
			case 1:
				System.out.print("ã�� ���� ������ �Է��Ͽ� �ּ���: ");
				String stringFindTitle = sc.nextLine();
				ArrayList<Board> listForFindTitle = dao.findBoardTitle(stringFindTitle);
				if (listForFindTitle.isEmpty()) {
					System.out.println("�˻� ����� �����ϴ�.");
				}
				else {
					System.out.println(listForFindTitle);
				}
				break;
			case 2:
				System.out.print("ã�� ���� ������ �Է��Ͽ� �ּ���: ");
				String stringFindContent = sc.nextLine();
				break;
			case 3:
				System.out.print("�˻��� ���� ��ȣ�� �Է��Ͽ� �ּ��� : ");
				str = sc.nextLine();
				if (Pattern.matches("^[0-9]*$", str)) {
					number = Integer.parseInt(str);
				}
				else {
					System.out.println("�߸��� ��ȣ �Է�");
					sc.nextLine();
					return;
				}
				ArrayList<Board> list = dao.findBoardNum(number);
				if (list.isEmpty()) {
					System.out.println("�˻� ����� �����ϴ�.");
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
			System.out.println("�߸��� ��ȣ �Է�");
			sc.nextLine();
			return;
		}
	}

}
