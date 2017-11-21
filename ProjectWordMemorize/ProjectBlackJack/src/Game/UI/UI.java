package Game.UI;

import java.util.ArrayList;
import java.util.Scanner;

import Game.DAO.GamerDAO;
import Game.VO.Card;
import Game.VO.Gamer;
import Game.VO.GamerStatus;
import Game.VO.RullAndPlay;

public class UI {
	
	Menu_Set menu = new Menu_Set();
	GamerDAO dao = new GamerDAO();
	RullAndPlay rull = new RullAndPlay();
	Scanner sc = new Scanner(System.in);
	
	
	public void start() {
		while(true) {			
			menu.startMenu();
			int sel = 0; 
			try {
				sel = sc.nextInt();
				sc.nextLine();
			} catch(Exception e) {
				sc.nextLine();
				System.err.println("�߸� �Է��Ͽ����ϴ�.");
				continue;
			}
			switch (sel) {
				case 1:	joinmembership(); break;				
				case 2: login();break;					
				case 9:
					System.err.println("�ý����� �����մϴ�.");
					return;
				default:
					break;
				}
		}
	}
	
	
	public void login() {
		rull.clearMedium();
		menu.loginWindow();
		System.out.print("ID : ");
		String login_id = sc.nextLine();
		System.out.print("Password : ");
		String login_pw = sc.nextLine();
		Gamer login_gamer = new Gamer(login_id, login_pw);
		if(dao.LoginGamer(login_gamer) == null) {
			System.err.println("��ġ�ϴ� ���̵� ���ų� ��ȣ�� �߸��Է��ϼ̽��ϴ�.");
		}
		else {
			rull.clearSmall();
			menu.gameWindow();
			System.out.println(tot_status(login_id));
			System.out.print("==> ");
			int choice1 = 0;
			try{
				choice1 = sc.nextInt();
				sc.nextLine();
			} catch(Exception e) {
				System.err.println("�߸��Է��ϼ̽��ϴ�.");
				sc.nextLine();
				return;
			}
///////////////////////////////////////////////////////////////
			//���⼭ ���� �÷��� ���� �޼ҵ�� ��
			if(choice1 == 1) {
				playgame(login_id);
			}			
			else if(choice1 == 2) {
				System.err.println("�α׾ƿ��մϴ�.");
				return;
			}			
			else {
				System.err.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
	
	public int zero_money(String login_id) {
		GamerStatus gamer = dao.total_status(login_id);
		int money = gamer.getMoney();
		if(money < 1) {
			System.err.println("������ ���� ��� ������ ���� �� �� �����ϴ�.");
			return 100;
		}
		return 0;
	}
	
	public void playgame(String login_id) {
		rull.clearAll();
		if(zero_money(login_id) == 100) {
			rull.clearSmall();
			return;
		}
		System.out.println("������ �����մϴ�.");
		while(true) {
			ArrayList<Card> deck = rull.play();
			ArrayList<Card> user = new ArrayList<>();
			ArrayList<Card> dealer = new ArrayList<>();
			int user_count = 0;
			int dealer_count = 0;
			
			//���� ù��° ��
			System.out.println("�÷����� ���Դϴ�.");
			user.add(deck.get(0));
			deck.remove(0);
			System.out.println(user.get(0));			
			System.out.print("���͸� �����ø� ������ ����˴ϴ�. ==>");
			sc.nextLine();
			rull.clearSmall();
			
			//���� ù��° ��
			System.out.println("������ �� 1���� �����մϴ�.");
			dealer.add(deck.get(0));
			deck.remove(0);
			System.out.println(dealer.get(0));
			
			System.out.print("���͸� �����ø� 2��° �и� ���� �� �ֽ��ϴ�. ==>");
			sc.nextLine();
			
			//����, ���� �ι�° ��
			System.out.println("������ ���� 2��° ī�带 �޽��ϴ�.");
			user.add(deck.get(0));
			deck.remove(0);
			for(int i=0; i<user.size(); i++) { //�������� ���
				user_count = user_count + user.get(i).getPoint();
			}			
			dealer.add(deck.get(0));
			deck.remove(0);			
			for(int i=0; i<dealer.size(); i++) { //�������� ���
				dealer_count = dealer_count + dealer.get(i).getPoint();
			}
			
			rull.clearSmall();
			System.out.println("������ ���� ���Դϴ�.");
			for(int i=0; i<user.size();i ++) {
				System.out.print(user.get(i)+"  ");
			}
			rull.clearSmall();
			//���� 16���ϸ� 3��° �� �ް� ������ �����ؼ� 3��°�� �޴´�
			if(dealer_count < 17) {
				dealer.add(deck.get(0));
				deck.remove(0);
				dealer_count = dealer_count + dealer.get(2).getPoint();
				System.out.println("������ ���� 16�������̹Ƿ� 1�� �� �̽��ϴ�. ");
			}
			else {
				System.out.println("������ ���� 17���̻��̹Ƿ� �� ���� �ʽ��ϴ�. ");
			}
			
			System.out.print("�� �����ðڽ��ϱ�? (y/n) : ");
			String choice1 = sc.nextLine();
			if(choice1.equalsIgnoreCase("n")) {
				rull.clearSmall();
				System.out.println("ī�带 �� ���� �ʰ� ������ Ȯ���մϴ�.");
			}
			
			
			else if(choice1.equalsIgnoreCase("y")) {
				user.add(deck.get(0));
				deck.remove(0);
				user_count = user_count + user.get(2).getPoint();
				rull.clearSmall();
				System.out.println("���� ������ ��");
				for(int i=0; i<user.size();i ++) {
					System.out.print(user.get(i)+"  ");
				}
				System.out.println("");
				System.out.print("�� �����ðڽ��ϱ�? (y/n) : ");
				String choice2 = sc.nextLine();
				if(choice2.equalsIgnoreCase("n")) {
					rull.clearSmall();
					System.out.println("ī�带 �� ���� �ʰ� ������ Ȯ���մϴ�.");
				}
				else if(choice2.equalsIgnoreCase("y")) {
					user.add(deck.get(0));
					deck.remove(0);
					user_count = user_count + user.get(3).getPoint();
					System.out.println("���� ������ ��");
					for(int i=0; i<user.size();i ++) {
						System.out.print(user.get(i)+"  ");
					}
				}
				rull.clearSmall();
				
			}
			
			int own_money = 0;
			GamerStatus Owns_money = dao.total_status(login_id);
			own_money = Owns_money.getMoney();
			int money = 0;
			while(true) {
				System.out.print("������ �ݾ��� �Է����ּ��� : ");
				money = sc.nextInt(); sc.nextLine();
				if(money > own_money) {
					System.err.println("�����ϰ� �ִ� ���� �ʰ� �Ͽ����ϴ�.");
				} else {
					break;
				}
			}
			
			System.out.print("���͸� �����ø� ������ ����˴ϴ�. ==>");
			sc.nextLine();
			rull.clearSmall();		
			
			
			System.out.print("���� ������ �� : ");
			for(int i=0; i<user.size();i ++) {
				System.out.print(user.get(i)+"  ");
			}
			System.out.println("");
			System.out.print("���� ������ �� : ");
			for(int i=0; i<dealer.size();i ++) {
				System.out.print(dealer.get(i)+"  ");
			}
			System.out.println("");
			
			
			int win_or_lose = rull.grading(user_count, dealer_count);
			if(win_or_lose == 1) {
				System.out.println("������ �¸��Դϴ�.");
				//
				win_money(login_id, money);
				win_count(login_id);
				GamerStatus gamer = tot_status(login_id);
				System.out.println(gamer.toString());
			}
			else if(win_or_lose == 2){
				System.out.println("������ �¸��Դϴ�.");
				lose_money(login_id, money);
				lose_count(login_id);
				GamerStatus gamer = tot_status(login_id);
				System.out.println(gamer.toString());
				if(gamer.getMoney() < 1) {
					System.out.println("�� �̻� ������ ���� �����ϴ�.");
					return;
				}
			}
			else if(win_or_lose == 3){
				System.out.println("�����ϴ�.");
				tot_status(login_id);
				GamerStatus gamer = tot_status(login_id);
				System.out.println(gamer.toString());
			}
			else {
				System.err.println("???????");
			}
			
			System.out.print("������ �̾ �Ͻðڽ��ϱ�?(y/n) : ");
			String choice3 = sc.nextLine();
			if(choice3.equalsIgnoreCase("n")) {
				rull.clearAll();
				break;
			} else if(choice3.equalsIgnoreCase("y")) {
				System.out.println("������ �ٽ� �����մϴ�.");
				rull.clearMedium();
			} else {
				System.out.println("�߸� �������ϴ�.");
				break;
			}			
			
		}	
	}
	
	public void win_count(String id) {
		dao.wins_count(id);		
	}
	
	public void lose_count(String id) {
		dao.loses_count(id);
	}
	
	public GamerStatus tot_status(String id) {
		GamerStatus gamer = dao.total_status(id);
		return gamer;
	}
	
	public void win_money(String login_id, int money) {
		dao.win_money(login_id, money);	
	}
	
	public void lose_money(String login_id, int money) {
		dao.lose_money(login_id, money);		
	}
	
	
	public void joinmembership() {
		rull.clearMedium();
		menu.joinWindow();
		System.out.println("����Ͻ� ���̵�� �н����带 �Է����ּ���.");
		System.out.print("ID : ");
		
		String id = sc.nextLine();
		if(dao.IDCheckGamer(id) == false) {
			System.err.println("�ߺ��� ���̵� �ֽ��ϴ�.");
			rull.clearSmall();
			return;
		}
		System.out.print("Password : ");
		String password = sc.nextLine();
		Gamer gamer = new Gamer(id, password);
		if(dao.insertGamer(gamer) == true) {
			System.out.println("��ϵǾ����ϴ�.");
			
			//�߰����� �ʱ�ȭ
			if(dao.AddGamerInfo(id) == true) {
				System.out.println("��Ȱ�� ������ ���� 100000���� �����Ͽ����ϴ�.");
				System.out.println("��ſ� �ð� ��������.");			
				rull.clearMedium();
			}
			else {
				System.out.println("�Ա� ����");
			}
			//
		}
		else {
			System.err.println("��Ͻ��Ф̤�");
		}
		
		
		
		
	}

}
