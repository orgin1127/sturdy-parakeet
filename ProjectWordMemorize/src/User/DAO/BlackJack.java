package User.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import User.VO.BlackJackGameVO;
import User.VO.UserInfomation;

public class BlackJack {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	Scanner sc = new Scanner(System.in);
	static String pattern = "";
	static String number = "";
	static ArrayList<BlackJackGameVO> deck = new ArrayList<>();
	
	public void startBlackJack(UserInfomation user) {
		while(true) {
			int aftercheckMenu = 99;
			printBlackJackMenu();
			String selectMenu = sc.nextLine();
			if (Pattern.matches("^[0-9]*$", selectMenu)) {
				aftercheckMenu = Integer.parseInt(selectMenu);
			}
			SqlSession session = null;
			try {
				session = factory.openSession();
				UserMapper um = session.getMapper(UserMapper.class);
				BlackJackGameVO bj = um.searchBlackJack(user);
				if (bj == null) {
					bj = new BlackJackGameVO(user.getAccountnumber());
					um.inserBlackJackUser(bj);
					session.commit();
				}
				switch (aftercheckMenu) {
				case 1:
					startGame(user, bj);
					break;
				case 2:
					break;
				case 0:
					return;
				default:
					continue;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				if (session != null) session.close();
			}
		}
	}
	
	
	public void startGame(UserInfomation user, BlackJackGameVO bj) {
		boolean flag = true;
		ArrayList<BlackJackGameVO> gameUser = new ArrayList<>();
		ArrayList<BlackJackGameVO> gameDealer = new ArrayList<>();
		int turn = 1, cnt = 0;
		int userScore = 0, dealerScore = 0;
		int money = bj.getMoney();
		int batting = 0;
		int win_count = bj.getWinCount();
		int lose_count = bj.getLoseCount();
		String check = "";
		deck = createCard(user);
		clearConsol();
		System.out.println("───────────────────────────");
		System.out.println("────S T A R T   G A M E────");
		System.out.println("───────────────────────────");
		System.out.println("");
		while (flag) {
			clearConsol();
			int intForabstract = 0;
			if (cnt<=3) {
				if (turn == 1) {
					clearConsol();
					System.out.println("기본 베팅 금액 2000원입니다. ");
					if (money < 2000) {
						System.out.println("금액이 부족합니다. 단어 게임을 통해 돈을 얻을 수 있습니다.");
						return;
					}
					money = money - 2000;
					System.out.println("플레이어가 카드를 한 장 뽑습니다");
					gameUser.add(drawCard());
					userScore = userScore + Integer.parseInt(gameUser.get(intForabstract).openCard().substring(3));
					for (BlackJackGameVO blackJackGameVO : gameUser) {
						System.out.print("가지고 있는 패 : "+blackJackGameVO.openCard());
					}
					turn = 0;
					cnt++;
				}
				else if (turn == 0){
					System.out.println("딜러가 카드를 한 장 뽑습니다.");
					gameDealer.add(drawCard());
					dealerScore = dealerScore + Integer.parseInt(gameDealer.get(intForabstract).openCard().substring(3));
					System.out.println(dealerScore+" 점");
					for (BlackJackGameVO blackJackGameVO : gameDealer) {
						System.out.print("가지고 있는 패 : "+blackJackGameVO.openCard());
					}
					turn = 1;
					cnt++;
					intForabstract++;
				}
			}
			else if (cnt>3 && (userScore<=21 || dealerScore<21)) {
				clearConsol();
				if (dealerScore<=16) {
					System.out.println("딜러가 16점 이하이므로 자동으로 카드 하나를 뽑습니다.");
					gameDealer.add(drawCard());
					dealerScore = dealerScore + Integer.parseInt(gameDealer.get(intForabstract).openCard().substring(3));
					intForabstract++;
				}
				else if (dealerScore>=17 && dealerScore <=21) {
					System.out.println("딜러는 16점을 초과하여 더이상 카드를 뽑지 않습니다.");
				}
				while (true) {
					System.out.println(user.getUserID()+"님의 현재 점수는  "+userScore+" 입니다.");
					System.out.print("카드를 한 장 더 뽑으시겠습니까? (Y/N)");
					String select = sc.nextLine();
					if ((select.toLowerCase().equals("y")||select.toLowerCase().equals("n")&&select.length()==1)) {
						switch (select) {
							case "y":
								gameUser.add(drawCard());
								userScore = userScore + Integer.parseInt(gameUser.get(intForabstract).openCard().substring(3));
								
								intForabstract++;
								for (BlackJackGameVO blackJackGameVO : gameUser) {
									System.out.print("가지고 있는 패 : "+blackJackGameVO.openCard());
								}
								break;
	
							case "n":
								System.out.println("점수를 계산합니다.");
								System.out.print("베팅액을 입력하여 주세요: ");
								check = sc.nextLine();
								if (Pattern.matches("^[0-9]*$", check)&&check != "") {
									batting = Integer.parseInt(check);
								}
								else {
									System.out.println("금액을 잘못 입력하셨습니다. 다시 입력하여 주세요");
									continue;
								}
								if (userScore>=dealerScore) {
									System.out.println(user.getUserID()+"님의 승리입니다.");
									if (userScore==21) {
										money = money+(batting*2)+(int)(2000*1.2);
										win_count = win_count+1;
									}
									else {
										money = money+(int)(batting*1.5)+(int)(2000*1.2);
										win_count = win_count+1;
									}
								}
								else {
									System.out.println(user.getUserID()+"님의 패배입니다.");
									lose_count = lose_count+1;
								}
								
								break;
						}
					}
					else {
						System.out.println("y 혹은 n으로 선택하여 주시기 바랍니다.");
						continue;
					}
				}
			}
			else if (userScore > 21) {
				System.out.println(user.getUserID()+"님의 점수가 21점을 초과하여 패배하였습니다.");
				lose_count = lose_count+1;
			}
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void updateBlackJack(BlackJackGameVO bj) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
	}
	
	
	public BlackJackGameVO drawCard() {
		Collections.shuffle(deck);
		BlackJackGameVO bj =deck.get(0);
		deck.remove(0);
		return bj;
	}
	
	public void printBlackJackMenu() {
		System.out.println("");
		System.out.println("\t"+"\t"+"──────────────────────────────────────────");
		System.out.println("\t"+"\t"+"────────────────BLACK JACK────────────────");
		System.out.println("\t"+"\t"+"──────────────────────────────────────────");
		System.out.println("");
		System.out.println("\t"+"\t"+"1. Start");
		System.out.println("\t"+"\t"+"2. ");
		System.out.println("\t"+"\t"+"0. ");
		System.out.println("");
		System.out.print("\t"+"\t"+"=> ");
	}
	
	public ArrayList<BlackJackGameVO> createCard(UserInfomation user) {
		String[] pattern = {"♠", "♥", "♦", "♣"};
		int count = 13;
		ArrayList<BlackJackGameVO> blackJackCardList = new ArrayList<>();
		
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 1; j <= count; j++) {
				if (j == 1) {
					BlackJackGameVO bj = new BlackJackGameVO(pattern[i], "A");
					blackJackCardList.add(bj);
				}
				else if (j == 11) {
					BlackJackGameVO bj = new BlackJackGameVO(pattern[i], "J");
					blackJackCardList.add(bj);
				}
				else if (j == 12) {
					BlackJackGameVO bj = new BlackJackGameVO(pattern[i], "Q");
					blackJackCardList.add(bj);
				}
				else if (j == 13) {
					BlackJackGameVO bj = new BlackJackGameVO(pattern[i], "K");
					blackJackCardList.add(bj);
				}
				else {
					BlackJackGameVO bj = new BlackJackGameVO(pattern[i], Integer.toString(j));
					blackJackCardList.add(bj);
				}
			}
		}
		return blackJackCardList;
	}
	
	public void clearConsol() {
		for (int i = 0; i <= 25; i++) {
			System.out.println("");
		}
	}

}
