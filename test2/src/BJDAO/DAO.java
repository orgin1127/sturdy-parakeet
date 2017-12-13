
package BJDAO;

import java.util.ArrayList;
import java.util.Collections;

import BJVO.BJVO;

public class DAO {
	static ArrayList<BJVO> deck = createCard();
	public static ArrayList<BJVO> createCard() {
		String[] pattern = {"♠", "♥", "♦", "♣"};
		int count = 13;
		ArrayList<BJVO> blackJackCardList = new ArrayList<>();
		
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 1; j <= count; j++) {
				if (j == 1) {
					BJVO bj = new BJVO(pattern[i], "A");
					blackJackCardList.add(bj);
				}
				else if (j == 11) {
					BJVO bj = new BJVO(pattern[i], "J");
					blackJackCardList.add(bj);
				}
				else if (j == 12) {
					BJVO bj = new BJVO(pattern[i], "Q");
					blackJackCardList.add(bj);
				}
				else if (j == 13) {
					BJVO bj = new BJVO(pattern[i], "K");
					blackJackCardList.add(bj);
				}
				else {
					BJVO bj = new BJVO(pattern[i], Integer.toString(j));
					blackJackCardList.add(bj);
				}
			}
		}
		Collections.shuffle(blackJackCardList);
		return blackJackCardList;
	}
	
	
	public BJVO drawCard() {
		BJVO card = deck.get(0);
		deck.remove(0);
		return card;
	}
}


