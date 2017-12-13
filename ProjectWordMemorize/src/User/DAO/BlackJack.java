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
			clearConsol();
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
					if(um.insertBlackJackUser(bj) == 1) {
						//System.out.println("[디버깅용] 블랙잭 유저 등록 성공");
					}
					session.commit();
					session.close();
				}
				switch (aftercheckMenu) {
				case 1:
					startGame(user);
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
	
	
	public void startGame(UserInfomation user) {
		boolean flag = true;
		ArrayList<BlackJackGameVO> gameUser = new ArrayList<>();
		ArrayList<BlackJackGameVO> gameDealer = new ArrayList<>();
		BlackJackGameVO bj = null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			bj = um.searchBlackJack(user);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		int turn = 1, cnt = 0;
		int userScore = 0, dealerScore = 0;
		int money = bj.getMoney();
		int batting = 0;
		int win_count = bj.getWinCount();
		int lose_count = bj.getLoseCount();
		int intForabstract = 0;
		String check = "";
		deck = createCard(user);
		Collections.shuffle(deck);
		clearConsol();
		System.out.println("───────────────────────────");
		System.out.println("────S T A R T   G A M E────");
		System.out.println("───────────────────────────");
		System.out.println("");
		System.out.println("기본 베팅 금액 2000원이 차감됩니다. ");
		if (money < 2000) {
			System.out.println("금액이 부족합니다. 단어 게임을 통해 돈을 얻을 수 있습니다.");
			return;
		}
		money = money - 2000;
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		while (flag) {
			clearConsol();
			if (cnt<=3) {
				if (turn == 1) {
					clearConsol();
					System.out.println("플레이어가 카드를 한 장 뽑습니다");
					gameUser.add(drawCard());
					if (gameUser.get(intForabstract).openCard().substring(1).equals("A")) {
						userScore = userScore + 1;
					}
					else if (gameUser.get(intForabstract).openCard().substring(1).equals("J")) {
						userScore = userScore + 11;
					}
					else if (gameUser.get(intForabstract).openCard().substring(1).equals("Q")) {
						userScore = userScore + 12;
					}
					else if (gameUser.get(intForabstract).openCard().substring(1).equals("K")) {
						userScore = userScore + 13;
					}
					else {
						userScore = userScore + Integer.parseInt(gameUser.get(intForabstract).openCard().substring(1));
					}
					System.out.print("가지고 있는 패 : ");
					for (BlackJackGameVO blackJackGameVO : gameUser) {
						System.out.print(blackJackGameVO.openCard()+" ");
					}
					cnt++;
					turn = 0;
				}
				else if (turn == 0){
					System.out.println("딜러가 카드를 한 장 뽑습니다.");
					gameDealer.add(drawCard());
					if (gameDealer.get(intForabstract).openCard().substring(1).equals("A")) {
						dealerScore = dealerScore + 1;
					}
					else if (gameDealer.get(intForabstract).openCard().substring(1).equals("J")) {
						dealerScore = dealerScore + 11;
					}
					else if (gameDealer.get(intForabstract).openCard().substring(1).equals("Q")) {
						dealerScore = dealerScore + 12;
					}
					else if (gameDealer.get(intForabstract).openCard().substring(1).equals("K")) {
						dealerScore = dealerScore + 13;
					}
					else {
						dealerScore = dealerScore + Integer.parseInt(gameDealer.get(intForabstract).openCard().substring(1));
					}
					System.out.print("딜러 뭐 : ");
					for (BlackJackGameVO blackJackGameVO : gameDealer) {
						System.out.print(blackJackGameVO.openCard()+" ");
					}
					turn = 1;
					cnt++;
					intForabstract++;
				}
				
			}
			else if (cnt>=4) {
				clearConsol();
				if (dealerScore<=16) {
					System.out.println("딜러가 16점 이하이므로 자동으로 카드 하나를 뽑습니다.");
					gameDealer.add(drawCard());
					if (gameDealer.get(intForabstract).openCard().substring(1).equals("A")) {
						dealerScore = dealerScore + 1;
					}
					else if (gameDealer.get(intForabstract).openCard().substring(1).equals("J")) {
						dealerScore = dealerScore + 11;
					}
					else if (gameDealer.get(intForabstract).openCard().substring(1).equals("Q")) {
						dealerScore = dealerScore + 12;
					}
					else if (gameDealer.get(intForabstract).openCard().substring(1).equals("K")) {
						dealerScore = dealerScore + 13;
					}
					else {
						dealerScore = dealerScore + Integer.parseInt(gameDealer.get(intForabstract).openCard().substring(1));
					}
				}
				else if (dealerScore>=17 && dealerScore <=21) {
					System.out.println("딜러는 16점을 초과하여 더이상 카드를 뽑지 않습니다.");
				}
				while (true) {
					System.out.println(user.getUserID()+"님의 현재 점수는  "+userScore+" 입니다.");
					System.out.print(user.getUserID()+"님이 가지고 있는 패 : ");
					for (BlackJackGameVO blackJackGameVO : gameUser) {
						System.out.print(blackJackGameVO.openCard()+" ");
					}
					System.out.println("딜러의 공개된 카드 : "+gameDealer.get(0).openCard());
					System.out.println("");
					System.out.print("카드를 한 장 더 뽑으시겠습니까? (Y/N)");
					String select = sc.nextLine();
					
					if ((select.toLowerCase().equals("y")||select.toLowerCase().equals("n")&&select.length()==1)) {
						switch (select) {
							case "y":
								System.out.print("베팅액을 입력하여 주십시오(현재 유저의 소지금액"+money+") : ");
								check = sc.nextLine();
								if (Pattern.matches("^[0-9]*$", check)&&check != "") {
									batting = Integer.parseInt(check);
									if (money - batting <= 0) {
										System.out.println("잔액이 부족합니다.");
										continue;
									}
									money = money - batting;
								}
								else {
									System.out.println("금액을 잘못 입력하셨습니다. 다시 입력하여 주세요");
									continue;
								}
								gameUser.add(drawCard());
								if (gameUser.get(intForabstract).openCard().substring(1).equals("A")) {
									userScore = userScore + 1;
								}
								else if (gameUser.get(intForabstract).openCard().substring(1).equals("J")) {
									userScore = userScore + 11;
								}
								else if (gameUser.get(intForabstract).openCard().substring(1).equals("Q")) {
									userScore = userScore + 12;
								}
								else if (gameUser.get(intForabstract).openCard().substring(1).equals("K")) {
									userScore = userScore + 13;
								}
								else {
									userScore = userScore + Integer.parseInt(gameUser.get(intForabstract).openCard().substring(1));
								}
								intForabstract++;
								break;
	
							case "n":
								System.out.println("점수를 계산합니다.");
								System.out.print("베팅액을 입력하여 주십시오(현재 유저의 소지금액"+money+") : ");
								check = sc.nextLine();
								if (Pattern.matches("^[0-9]*$", check)&&check != "") {
									batting = Integer.parseInt(check);
								}
								else {
									System.out.println("금액을 잘못 입력하셨습니다. 다시 입력하여 주세요");
									continue;
								}
								if (userScore>=dealerScore && userScore <= 21) {
									System.out.println(user.getUserID()+"님의 승리입니다.");
									if (userScore==21) {
										money = money+(batting*2)+(int)(2000*1.2);
										win_count = win_count+1;
										try {
											Thread.sleep(1500);
										}
										catch (Exception e) {
											e.printStackTrace();
										}
									}
									else {
										money = money+(int)(batting*1.5)+(int)(2000*1.2);
										win_count = win_count+1;
										try {
											Thread.sleep(1500);
										}
										catch (Exception e) {
											e.printStackTrace();
										}
									}
								}
								else {
									System.out.println(user.getUserID()+"님의 점수 : "+userScore);
									System.out.println("딜러의 점수 : "+dealerScore);
									System.out.println(user.getUserID()+"님의 패배입니다.");
									lose_count = lose_count+1;
									try {
										Thread.sleep(1500);
									}
									catch (Exception e) {
										e.printStackTrace();
									}
								}
								bj = new BlackJackGameVO(user.getAccountnumber(), money, win_count, lose_count);
								updateBlackJack(bj);
								return;
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
			if (um.updateBlackJack(bj) == 1) {
				//System.out.println("[디버그용] 블랙잭 전적 갱신 성공");
			}
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
	}
	
	
	public BlackJackGameVO drawCard() {
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
		System.out.println("\t"+"\t"+"0. Return");
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
		for (int i = 0; i <= 30; i++) {
			System.out.println("");
		}
	}

}
