package User.DAO;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import User.UI2.UICompilation;
import User.VO.*;

public class BlinkGame {
	Scanner sc = new Scanner(System.in);
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	UICompilation ui = new UICompilation();
	
	public void blinkGameStart(UserInfomation user) {
		while (true) {
			printBlinkGameMenu();
			String selectBlinkGameMenu = sc.nextLine();
			switch (afterValidCheckNumber(selectBlinkGameMenu)) {
				case 1:
					startBlinkGame(user);
					break;
				case 2:
					showRanking(user);
					break;
				case 99:
					break;
				case 0:
					return;
				default:
					continue;
			}
		}
		
	}
	
	public void startBlinkGame(UserInfomation user) {
		
		SqlSession session = null;
		session = factory.openSession();
		UserMapper um = session.getMapper(UserMapper.class);
		System.out.println("ゲームをする単語帳を選択してください");
		System.out.println("1. N 1 ");
		System.out.println("2. N 2 ");
		System.out.println("3. N 3 ");
		System.out.println("4. カスタム単語帳");
		System.out.println("5. 全ての単語帳");
		System.out.println("0. 戻る");
		System.out.print("入力=>　");
		String selectWordMemorizeNumber = sc.nextLine();
		BlinkGameVO bg = um.searchResult(user);
		int maxCombo = 0;
		int highScore = 0;
		int clearCount = 0;
		
		if (bg != null) {
			highScore = bg.getHighScore();
			clearCount = bg.getClearWordCount();
			maxCombo = bg.getMaxCombo();
		}
		
		int cnt = 0;
		int lifeForBlinkGame = 0;
		int blinkCount = 1;
		
		int combo = 0;
		int score = 0;
		
		try { 
			switch (afterValidCheckNumber(selectWordMemorizeNumber)) {
				case 1:
					ArrayList<N1> listForBlinkGameN1;
					listForBlinkGameN1 =  um.viewWordN1("N1");
					session.commit();
					Collections.shuffle(listForBlinkGameN1);
					lifeForBlinkGame = 5;
					do {
						if (blinkCount <= 5) {
							//출력하고
							System.out.println("\t"+"\t"+"\t"+"\t"+"残りライフ："+lifeForBlinkGame);
							System.out.println("\t"+"\t"+"\t"+"\t"+"HighScore："+highScore);
							System.out.println("\t"+"\t"+"\t"+"\t"+"Combo："+combo);
							System.out.println("\t"+"\t"+"\t"+"\t"+"点数："+score);
							System.out.println("");
							System.out.println("\t"+"\t"+"No. "+cnt+" "+listForBlinkGameN1.get(cnt).getKanji());
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							//딜레이
							UICompilation.delay();
							//지우고
							UICompilation.clear();
							//2초 딜레이
							UICompilation.delay();
							blinkCount++;
						}
						if (blinkCount == 5) {
							blinkCount = 1;
							System.out.print("単語のよみがなを入力して下さい： ");
							System.out.print("（ゲームを中止したい場合にはもう１回エンターを入力して下さい。）＝＞");
							String answer = sc.nextLine();
							if (answer.equals(listForBlinkGameN1.get(cnt).getYomigana())) {
								System.err.println("正解、次の単語を出力します。");
								cnt++;
								combo = combo+1;
								score = score+5+(combo*2);
								clearCount++;
							}
							else if (answer.isEmpty()) {
								System.out.println("");
								System.err.println("ゲームを終了します。");
								break;
							}
							else {
								System.err.println("不正解です。");
								lifeForBlinkGame--;
								cnt++;
								combo = 0;
							}
							if (combo>=maxCombo) maxCombo = combo;
							if (score>=highScore) highScore = score;
						}
					} while (cnt <= listForBlinkGameN1.size() || lifeForBlinkGame==0);
					
					if (bg == null) {
						bg = new BlinkGameVO(user.getAccountnumber(), clearCount, maxCombo, highScore);
						if (um.blinkGameResult(bg) == 1) System.err.println("========終わり========");
						session.commit();
					}
					else if (bg != null) {
						bg = new BlinkGameVO(user.getAccountnumber(), clearCount, maxCombo, highScore);
						if (um.blinkGameUpdate(bg) == 1) System.out.println("========終わり========");
						session.commit();
					}
					UICompilation.delay();
					UICompilation.clear();
					break;
				case 2:
					ArrayList<N2> listForBlinkGameN2;
					listForBlinkGameN2 = um.viewWordN2("N2");
					session.commit();

					Collections.shuffle(listForBlinkGameN2);
					lifeForBlinkGame = 7;
					do {
						if (blinkCount <= 5) {
							//출력하고
							System.out.println("\t"+"\t"+"\t"+"\t"+"残りライフ："+lifeForBlinkGame);
							System.out.println("\t"+"\t"+"\t"+"\t"+"HighScore："+highScore);
							System.out.println("\t"+"\t"+"\t"+"\t"+"Combo："+combo);
							System.out.println("\t"+"\t"+"\t"+"\t"+"点数："+score);
							System.out.println("");
							System.out.println("\t"+"\t"+"No. "+cnt+" "+listForBlinkGameN2.get(cnt).getKanji());
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							//딜레이
							UICompilation.delay();
							//지우고
							UICompilation.clear();
							//2초 딜레이
							UICompilation.delay();
							blinkCount++;
						}
						if (blinkCount == 5) {
							blinkCount = 1;
							System.out.print("単語のよみがなを入力して下さい： ");
							System.out.print("（ゲームを中止したい場合にはもう１回エンターを入力して下さい。）＝＞");
							String answer = sc.nextLine();
							if (answer.equals(listForBlinkGameN2.get(cnt).getYomigana())) {
								System.err.println("正解、次の単語を出力します。");
								cnt++;
								combo = combo+1;
								score = score+5+(combo*2);
								clearCount++;
							}
							else if (answer.isEmpty()) {
								System.out.println("");
								System.err.println("ゲームを終了します。");
								break;
							}
							else {
								System.err.println("不正解です。");
								lifeForBlinkGame--;
								cnt++;
								combo = 0;
							}
							if (combo>=maxCombo) maxCombo = combo;
							if (score>=highScore) highScore = score;
						}
					} while (cnt <= listForBlinkGameN2.size() || lifeForBlinkGame==0);
					
					if (bg == null) {
						bg = new BlinkGameVO(user.getAccountnumber(), clearCount, maxCombo, highScore);
						if (um.blinkGameResult(bg) == 1) System.err.println("========終わり========");
						session.commit();
					}
					else if (bg != null) {
						bg = new BlinkGameVO(user.getAccountnumber(), clearCount, maxCombo, highScore);
						if (um.blinkGameUpdate(bg) == 1) System.out.println("========終わり========");
						session.commit();
					}
					UICompilation.delay();
					UICompilation.clear();
					break;
				case 3:
					ArrayList<N3> listForBlinkGameN3;
					listForBlinkGameN3 = um.viewWordN3("N3");
					session.commit();
					Collections.shuffle(listForBlinkGameN3);
					lifeForBlinkGame = 10;
					do {
						if (blinkCount <= 5) {
							//출력하고
							System.out.println("\t"+"\t"+"\t"+"\t"+"残りライフ："+lifeForBlinkGame);
							System.out.println("\t"+"\t"+"\t"+"\t"+"HighScore："+highScore);
							System.out.println("\t"+"\t"+"\t"+"\t"+"Combo："+combo);
							System.out.println("\t"+"\t"+"\t"+"\t"+"点数："+score);
							System.out.println("");
							System.out.println("\t"+"\t"+"No. "+cnt+" "+" "+listForBlinkGameN3.get(cnt).getKanji());
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							//딜레이
							UICompilation.delay();
							//지우고
							UICompilation.clear();
							//2초 딜레이
							UICompilation.delay();
							blinkCount++;
						}
						if (blinkCount == 5) {
							blinkCount = 1;
							System.out.print("単語のよみがなを入力して下さい： ");
							System.out.print("（ゲームを中止したい場合にはもう１回エンターを入力して下さい。）＝＞");
							String answer = sc.nextLine();
							if (answer.equals(listForBlinkGameN3.get(cnt).getYomigana())) {
								System.err.println("正解、次の単語を出力します。");
								cnt++;
								combo = combo+1;
								score = score+5+(combo*2);
								clearCount++;
							}
							else if (answer.isEmpty()) {
								System.out.println("");
								System.err.println("ゲームを終了します。");
								break;
							}
							else {
								System.err.println("不正解です。");
								lifeForBlinkGame--;
								cnt++;
								combo = 0;
							}
							if (combo>=maxCombo) maxCombo = combo;
							if (score>=highScore) highScore = score;
						}
					} while (cnt <= listForBlinkGameN3.size() || lifeForBlinkGame==0);
					
					if (bg == null) {
						bg = new BlinkGameVO(user.getAccountnumber(), clearCount, maxCombo, highScore);
						if (um.blinkGameResult(bg) == 1) System.err.println("========終わり========");
						session.commit();
					}
					else if (bg != null) {
						bg = new BlinkGameVO(user.getAccountnumber(), clearCount, maxCombo, highScore);
						if (um.blinkGameUpdate(bg) == 1) System.out.println("========終わり========");
						session.commit();
					}
					UICompilation.delay();
					UICompilation.clear();
					break;
				case 4:
					ArrayList<CustomMemorize> listForBlinkGameCustom;
					listForBlinkGameCustom = um.viewWordCustom(user);
					session.commit();
					Collections.shuffle(listForBlinkGameCustom);
					lifeForBlinkGame = 5;
					do {
						if (blinkCount <= 5) {
							//출력하고
							System.out.println("\t"+"\t"+"\t"+"\t"+"残りライフ："+lifeForBlinkGame);
							System.out.println("\t"+"\t"+"\t"+"\t"+"HighScore："+highScore);
							System.out.println("\t"+"\t"+"\t"+"\t"+"Combo："+combo);
							System.out.println("\t"+"\t"+"\t"+"\t"+"点数："+score);
							System.out.println("");
							System.out.println("\t"+"\t"+"No. "+cnt+" "+listForBlinkGameCustom.get(cnt).getKanji());
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							//딜레이
							UICompilation.delay();
							//지우고
							UICompilation.clear();
							//2초 딜레이
							UICompilation.delay();
							blinkCount++;
						}
						if (blinkCount == 5) {
							blinkCount = 1;
							System.out.print("単語のよみがなを入力して下さい： ");
							System.out.print("（ゲームを中止したい場合にはもう１回エンターを入力して下さい。）＝＞");
							String answer = sc.nextLine();
							if (answer.equals(listForBlinkGameCustom.get(cnt).getYomigana())) {
								System.err.println("正解、次の単語を出力します。");
								cnt++;
								combo = combo+1;
								score = score+5+(combo*2);
								clearCount++;
							}
							else if (answer.isEmpty()) {
								System.out.println("");
								System.err.println("ゲームを終了します。");
								break;
							}
							else {
								System.err.println("不正解です。");
								lifeForBlinkGame--;
								cnt++;
								combo = 0;
							}
							if (combo>=maxCombo) maxCombo = combo;
							if (score>=highScore) highScore = score;
						}
					} while (cnt <= listForBlinkGameCustom.size() || lifeForBlinkGame==0);
					
					if (bg == null) {
						bg = new BlinkGameVO(user.getAccountnumber(), clearCount, maxCombo, highScore);
						if (um.blinkGameResult(bg) == 1) System.err.println("========終わり========");
						session.commit();
					}
					else if (bg != null) {
						bg = new BlinkGameVO(user.getAccountnumber(), clearCount, maxCombo, highScore);
						if (um.blinkGameUpdate(bg) == 1) System.out.println("========終わり========");
						session.commit();
					}
					UICompilation.delay();
					UICompilation.clear();
					break;
				case 5:
					ArrayList<Word> listForBlinkGameAll;
					listForBlinkGameAll = um.viewAllWords();
					ArrayList<CustomMemorize> list = um.viewWordCustom(user);
					listForBlinkGameAll.addAll(list);
					session.commit();
					Collections.shuffle(listForBlinkGameAll);
					lifeForBlinkGame = 3;
					do {
						if (blinkCount <= 5) {
							//출력하고
							System.out.println("\t"+"\t"+"\t"+"\t"+"残りライフ："+lifeForBlinkGame);
							System.out.println("\t"+"\t"+"\t"+"\t"+"HighScore："+highScore);
							System.out.println("\t"+"\t"+"\t"+"\t"+"Combo："+combo);
							System.out.println("\t"+"\t"+"\t"+"\t"+"点数："+score);
							System.out.println("");
							System.out.println("\t"+"\t"+"No. "+cnt+", "+listForBlinkGameAll.get(cnt).getKanji());
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							//딜레이
							UICompilation.delay();
							//지우고
							UICompilation.clear();
							//2초 딜레이
							UICompilation.delay();
							blinkCount++;
						}
						if (blinkCount == 5) {
							blinkCount = 1;
							System.out.print("単語のよみがなを入力して下さい： ");
							System.out.print("（ゲームを中止したい場合にはもう１回エンターを入力して下さい。）＝＞");
							String answer = sc.nextLine();
							if (listForBlinkGameAll.get(cnt).toString().contains(answer)) {
								System.err.println("正解、次の単語を出力します。");
								cnt++;
								combo = combo+1;
								score = score+5+(combo*2);
								clearCount++;
							}
							else if (answer.isEmpty()) {
								System.out.println("");
								System.err.println("ゲームを終了します。");
								break;
							}
							else {
								System.err.println("不正解です。");
								lifeForBlinkGame--;
								cnt++;
								combo = 0;
							}
							if (combo>=maxCombo) maxCombo = combo;
							if (score>=highScore) highScore = score;
						}
					} while (cnt <= listForBlinkGameAll.size() || lifeForBlinkGame==0);
					
					
					if (bg == null) {
						bg = new BlinkGameVO(user.getAccountnumber(), clearCount, maxCombo, highScore);
						if (um.blinkGameResult(bg) == 1) System.err.println("========終わり========");
						session.commit();
					}
					else if (bg != null) {
						bg = new BlinkGameVO(user.getAccountnumber(), clearCount, maxCombo, highScore);
						if (um.blinkGameUpdate(bg) == 1) System.out.println("========終わり========");
						session.commit();
					}
					UICompilation.delay();
					UICompilation.clear();
					break;
				case 0:
					return;
				default:
					break;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
	}
	
	public void showRanking(UserInfomation user) {
		ArrayList<BlinkGameVO> rankList = new ArrayList<>();
		SqlSession session = null;
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			rankList = um.printBlinkGameRank();
			session.commit();
			
			int cnt = 0;
			for (BlinkGameVO blinkGameVO : rankList) {
				if (cnt <=9 ) {
					System.out.println(blinkGameVO.showRanking());
				cnt++;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		
	}

	public void printBlinkGameMenu() {
		System.out.println("1. ゲームスタート");
		System.out.println("2. トップ１０ランキングを見る");
		System.out.println("0. 戻る");
		System.out.print("メニューを選択してください＝＞ ");
	}
	
	public int afterValidCheckNumber(String number) {
		int afterValidCheck = 99;
		if (Pattern.matches("^[0-9]*$", number)) {
			afterValidCheck = Integer.parseInt(number);
		}
		else {
			System.err.println("正しい番号を入力してください");
			UICompilation.delay();
			UICompilation.clear();
		}
		return afterValidCheck;
	}
}
