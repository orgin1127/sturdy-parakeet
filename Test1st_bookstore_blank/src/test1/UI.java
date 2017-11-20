package test1;

import java.util.*;

/**
 * <pre>
 * ���� ���� ���α׷��� ����� ȭ��(User Interface) Ŭ����
 * ����ڷκ��� ó���� ���õ� �Է��� �ް�, Manager Ŭ������ ���� ó���� ����� �����ش�.
 * </pre>
 */
public class UI {
	//��û�� ���õ� ó���� �ϱ� ���� ������ Manager Ŭ������ ��ü
	private Manager manager;
	
	//Ű����κ��� ������ �Է¹ޱ� ���� ������ Scanner Ŭ������ ��ü
	private Scanner sc;
	
	/**
	 * ������.
	 * 
	 */
	public UI() {
		manager = new Manager();
		sc = new Scanner(System.in);
	}

	/**
	 * UI�� �����Ѵ�
	 */
	public void start() {
		// ���α׷� ���� ������ ��� �ݺ��Ѵ�
		boolean canContinue = true;
		
		while (canContinue) {
			System.out.println("����������������������������������������������������������������");
			System.out.println("��      ���� ���� �ý���        ��");
			System.out.println("����������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������");
			System.out.println("�� 1.���                       ��");	
			System.out.println("�� 2.ã��                       ��");	
			System.out.println("�� 3.����                       ��");	
			System.out.println("�� 4.��ü���                   ��");	
			System.out.println("�� 9.����                       ��");
			System.out.println("����������������������������������������������������������������");
			System.out.print("�޴� ��ȣ�� �����ϼ���=> ");
			int option = getNextInt(sc.nextLine());
			
			switch (option) {
				case 1:	// ���
					insert();
					break;
					
				case 2:	// �˻�
					select();
					break;
					
				case 3:	// ����
					delete();
					break;
					
				case 4:	// ��ü ���
					print();
					break;
					
				case 9:	// ����
					canContinue = false;
					break;
	
				default:
					System.out.println("[����] �߸��� �Է��Դϴ�");
			}
			
			System.out.println();
		}
	}
	
	/**
	 * �� ������ å ������ �Է� �޾� �˸´� ��ü�� �����ϰ�
	 * �̸� �Ŵ����� ���� �����Ѵ�
	 */
	private void insert() {
		// ���� ������ ��� �ݺ��Ѵ�
		boolean canContinue = true;
		
		while (canContinue) {
			System.out.println("����������������������������������������������������������������");
			System.out.println("��        ���� ���� ���        ��");
			System.out.println("����������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������");
			System.out.println("�� 1.å                         ��");	
			System.out.println("�� 2.������                     ��");	
			System.out.println("�� 3.����                       ��");	
			System.out.println("�� 9.�����޴�                   ��");
			System.out.println("����������������������������������������������������������������");
			System.out.print("�޴� ��ȣ�� �����ϼ���=> ");
			int option = getNextInt(sc.nextLine());
			
			// 9���̸� �����Ѵ�
			if (option == 9) {
				canContinue = false;
				sc.close();
				continue;
			}
			
			// 1 ~ 3�� ���̰� �ƴϸ� �ٽ� �Է� �޴´�
			if (option < 1 || 3 < option) {
				System.out.println("[����] �߸� �Է��ϼ̽��ϴ�");
				continue;
			}
			
			// ����� �����Ѵ�
			//CODE HERE
			Publication pub = null;
			int productId;
			String title;
			String company;	
			int price;
			
			switch (option) {
				case 1:	// å
					//CODE HERE
					System.out.print("��ǰ��ȣ: ");
					productId = getNextInt(sc.nextLine());
					System.out.print("����: ");
					title = sc.nextLine();
					System.out.print("���ǻ�: ");
					company = sc.nextLine();
					System.out.print("����: ");
					price = getNextInt(sc.nextLine());
					System.out.print("����: ");
					String author = sc.nextLine();
					pub = new Book(productId, title, company, price, author);
					if (manager.insert(pub)) {
						System.out.println("[�˸�] ����� �Ϸ��Ͽ����ϴ�.");
					}
					else {
						System.out.println("[�˸�] ����� �����Ͽ����ϴ�.");
					}
					break;
				case 2:	// ����å
					//CODE HERE
					System.out.print("��ǰ��ȣ: ");
					productId = getNextInt(sc.nextLine());
					System.out.print("����: ");
					title = sc.nextLine();
					System.out.print("���ǻ�: ");
					company = sc.nextLine();
					System.out.print("����: ");
					price = getNextInt(sc.nextLine());
					System.out.print("��������: ");
					String format = sc.nextLine();
					System.out.print("����ũ��(MB): ");
					int filesize = getNextInt(sc.nextLine());
					pub = new Ebook(productId, title, company, price, format, filesize);
					if (manager.insert(pub)) {
						System.out.println("[�˸�] ����� �Ϸ��Ͽ����ϴ�.");
					}
					else {
						System.out.println("[�˸�] ����� �����Ͽ����ϴ�.");
					}
					break;
					
				case 3:	// ����
					//CODE HERE
					System.out.print("��ǰ��ȣ: ");
					productId = getNextInt(sc.nextLine());
					System.out.print("����: ");
					title = sc.nextLine();
					System.out.print("���ǻ�: ");
					company = sc.nextLine();
					System.out.print("����: ");
					price = getNextInt(sc.nextLine());
					System.out.print("����⵵: ");
					int year = getNextInt(sc.nextLine());
					System.out.print("�����: ");
					int month = getNextInt(sc.nextLine());
					pub = new Magazine(productId, title, company, price, year, month);
					if (manager.insert(pub)) {
						System.out.println("[�˸�] ����� �Ϸ��Ͽ����ϴ�.");
					}
					else {
						System.out.println("[�˸�] ����� �����Ͽ����ϴ�.");
					}
					break;
			}
			
			//CODE HERE
			
			System.out.println();
		}
	}
	
	/**
	 * ��ǰ��ȣ�� �Է� �޾� �ش� ��ȣ�� ��ġ�ϴ� ��ǰ��ȣ�� ������ �ִ� ������ ����Ѵ�
	 */
	private void select() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("��             �˻�             ��");
		System.out.println("����������������������������������������������������������������");
		System.out.print("��ǰ��ȣ �Է�>> ");
		// ��ǰ ��ȣ�� �Է� �޴´�
		int productId = getNextInt(sc.nextLine());
		// �˻��Ͽ� ������ ã�´�
		Publication select = manager.select(productId);
		if (select != null) {
			System.out.println(select);
		}
		else {
			System.out.println("[�˸�] �ش� ��ǰ�� ã�� ���߽��ϴ�.");
		}
		
	}

	/**
	 * ��ǰ��ȣ�� �Է� �޾� �ش� ��ȣ�� ��ġ�ϴ� ��ǰ��ȣ�� ������ �ִ� ������ �����Ѵ�
	 */
	private void delete() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("��             ����             ��");
		System.out.println("����������������������������������������������������������������");
		System.out.print("��ǰ��ȣ �Է�>> ");
		// ��ǰ ��ȣ�� �Է� �޴´�
		int productId = getNextInt(sc.nextLine());
		// �����ϰ� ���� ���θ� Ȯ���Ѵ�
		if (manager.delete(productId)) {
			System.out.println("[�˸�] ������ �Ϸ��Ͽ����ϴ�.");
		}
		else {
			System.out.println("[�˸�] ������ �����Ͽ����ϴ�.");
		}
	}

	/**
	 * �Ŵ����κ��� ����Ʈ ������ ������ �ͼ� ��� ������ ����Ѵ�
	 */
	private void print() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("��          ��ü ���           ��");
		System.out.println("����������������������������������������������������������������");
		
		// ����Ʈ�� �����´�
		//CODE HERE
		List list = manager.getPubList();
		// �� �ǵ� �������� ������ �������� �˸��� �޼ҵ� ����
		//CODE HERE
		if (list==null) {
			System.out.println("[�˸�] ����� ������ �� �ǵ� �������� �ʽ��ϴ�.");
			return;
		}
		// ��ü ����Ѵ�
		//CODE HERE
		else {
			for (Object printList : list) {
				System.out.println(printList);
			}
		}
	}
	
	/**
	 * �� ó���� ���ڸ� �Է� �޴´�
	 * @return 0�� �ƴ� ����
	 */
	private int getNextInt(String message) {
		int option = 0;
		do {
			try {
				//System.out.print(message);
				option = Integer.parseInt(message);
				if (option == 0) {
					zeroException();
				}
			} catch (Exception e) {
				System.out.println("[����] �߸� �Է��Ͽ����ϴ�. �ٽ� �Է��Ͽ� �ּ���.");
				System.out.print("���Է�>> ");
				message = sc.nextLine();
			}
		} while(option == 0);
		return option;
	}
	public void zeroException() throws Exception {
		throw new Exception();
	}
	
}

