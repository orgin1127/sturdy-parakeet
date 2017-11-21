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
				System.err.println("잘못 입력하였습니다.");
				continue;
			}
			switch (sel) {
				case 1:	joinmembership(); break;				
				case 2: login();break;					
				case 9:
					System.err.println("시스템을 종료합니다.");
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
			System.err.println("일치하는 아이디가 없거나 암호를 잘못입력하셨습니다.");
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
				System.err.println("잘못입력하셨습니다.");
				sc.nextLine();
				return;
			}
///////////////////////////////////////////////////////////////
			//여기서 부터 플레이 게임 메소드로 들어감
			if(choice1 == 1) {
				playgame(login_id);
			}			
			else if(choice1 == 2) {
				System.err.println("로그아웃합니다.");
				return;
			}			
			else {
				System.err.println("잘못입력하셨습니다.");
			}
		}
	}
	
	public int zero_money(String login_id) {
		GamerStatus gamer = dao.total_status(login_id);
		int money = gamer.getMoney();
		if(money < 1) {
			System.err.println("배팅할 돈이 없어서 게임을 시작 할 수 없습니다.");
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
		System.out.println("게임을 시작합니다.");
		while(true) {
			ArrayList<Card> deck = rull.play();
			ArrayList<Card> user = new ArrayList<>();
			ArrayList<Card> dealer = new ArrayList<>();
			int user_count = 0;
			int dealer_count = 0;
			
			//유저 첫번째 패
			System.out.println("플레이의 패입니다.");
			user.add(deck.get(0));
			deck.remove(0);
			System.out.println(user.get(0));			
			System.out.print("엔터를 누르시면 게임이 진행됩니다. ==>");
			sc.nextLine();
			rull.clearSmall();
			
			//딜러 첫번째 패
			System.out.println("딜러의 패 1개를 공개합니다.");
			dealer.add(deck.get(0));
			deck.remove(0);
			System.out.println(dealer.get(0));
			
			System.out.print("엔터를 누르시면 2번째 패를 받을 수 있습니다. ==>");
			sc.nextLine();
			
			//딜러, 유저 두번째 패
			System.out.println("유저와 딜러 2번째 카드를 받습니다.");
			user.add(deck.get(0));
			deck.remove(0);
			for(int i=0; i<user.size(); i++) { //유저점수 계산
				user_count = user_count + user.get(i).getPoint();
			}			
			dealer.add(deck.get(0));
			deck.remove(0);			
			for(int i=0; i<dealer.size(); i++) { //딜러점수 계산
				dealer_count = dealer_count + dealer.get(i).getPoint();
			}
			
			rull.clearSmall();
			System.out.println("유저의 현재 패입니다.");
			for(int i=0; i<user.size();i ++) {
				System.out.print(user.get(i)+"  ");
			}
			rull.clearSmall();
			//딜러 16이하면 3번째 패 받고 유저는 선택해서 3번째패 받는다
			if(dealer_count < 17) {
				dealer.add(deck.get(0));
				deck.remove(0);
				dealer_count = dealer_count + dealer.get(2).getPoint();
				System.out.println("딜러는 덱이 16점이하이므로 1장 더 뽑습니다. ");
			}
			else {
				System.out.println("딜러는 덱이 17점이상이므로 더 뽑지 않습니다. ");
			}
			
			System.out.print("더 받으시겠습니까? (y/n) : ");
			String choice1 = sc.nextLine();
			if(choice1.equalsIgnoreCase("n")) {
				rull.clearSmall();
				System.out.println("카드를 더 받지 않고 점수를 확인합니다.");
			}
			
			
			else if(choice1.equalsIgnoreCase("y")) {
				user.add(deck.get(0));
				deck.remove(0);
				user_count = user_count + user.get(2).getPoint();
				rull.clearSmall();
				System.out.println("현재 유저의 패");
				for(int i=0; i<user.size();i ++) {
					System.out.print(user.get(i)+"  ");
				}
				System.out.println("");
				System.out.print("더 받으시겠습니까? (y/n) : ");
				String choice2 = sc.nextLine();
				if(choice2.equalsIgnoreCase("n")) {
					rull.clearSmall();
					System.out.println("카드를 더 받지 않고 점수를 확인합니다.");
				}
				else if(choice2.equalsIgnoreCase("y")) {
					user.add(deck.get(0));
					deck.remove(0);
					user_count = user_count + user.get(3).getPoint();
					System.out.println("현재 유저의 패");
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
				System.out.print("배팅할 금액을 입력해주세요 : ");
				money = sc.nextInt(); sc.nextLine();
				if(money > own_money) {
					System.err.println("보유하고 있는 돈을 초과 하였습니다.");
				} else {
					break;
				}
			}
			
			System.out.print("엔터를 누르시면 정산이 진행됩니다. ==>");
			sc.nextLine();
			rull.clearSmall();		
			
			
			System.out.print("현재 유저의 패 : ");
			for(int i=0; i<user.size();i ++) {
				System.out.print(user.get(i)+"  ");
			}
			System.out.println("");
			System.out.print("현재 딜러의 패 : ");
			for(int i=0; i<dealer.size();i ++) {
				System.out.print(dealer.get(i)+"  ");
			}
			System.out.println("");
			
			
			int win_or_lose = rull.grading(user_count, dealer_count);
			if(win_or_lose == 1) {
				System.out.println("유저의 승리입니다.");
				//
				win_money(login_id, money);
				win_count(login_id);
				GamerStatus gamer = tot_status(login_id);
				System.out.println(gamer.toString());
			}
			else if(win_or_lose == 2){
				System.out.println("딜러의 승리입니다.");
				lose_money(login_id, money);
				lose_count(login_id);
				GamerStatus gamer = tot_status(login_id);
				System.out.println(gamer.toString());
				if(gamer.getMoney() < 1) {
					System.out.println("더 이상 배팅할 돈이 없습니다.");
					return;
				}
			}
			else if(win_or_lose == 3){
				System.out.println("비겼습니다.");
				tot_status(login_id);
				GamerStatus gamer = tot_status(login_id);
				System.out.println(gamer.toString());
			}
			else {
				System.err.println("???????");
			}
			
			System.out.print("게임을 이어서 하시겠습니까?(y/n) : ");
			String choice3 = sc.nextLine();
			if(choice3.equalsIgnoreCase("n")) {
				rull.clearAll();
				break;
			} else if(choice3.equalsIgnoreCase("y")) {
				System.out.println("게임을 다시 시작합니다.");
				rull.clearMedium();
			} else {
				System.out.println("잘못 눌렀습니다.");
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
		System.out.println("등록하실 아이디와 패스워드를 입력해주세요.");
		System.out.print("ID : ");
		
		String id = sc.nextLine();
		if(dao.IDCheckGamer(id) == false) {
			System.err.println("중복된 아이디가 있습니다.");
			rull.clearSmall();
			return;
		}
		System.out.print("Password : ");
		String password = sc.nextLine();
		Gamer gamer = new Gamer(id, password);
		if(dao.insertGamer(gamer) == true) {
			System.out.println("등록되었습니다.");
			
			//추가정보 초기화
			if(dao.AddGamerInfo(id) == true) {
				System.out.println("원활한 게임을 위해 100000원을 지급하였습니다.");
				System.out.println("즐거운 시간 보내세요.");			
				rull.clearMedium();
			}
			else {
				System.out.println("입금 실패");
			}
			//
		}
		else {
			System.err.println("등록실패ㅜㅜ");
		}
		
		
		
		
	}

}
