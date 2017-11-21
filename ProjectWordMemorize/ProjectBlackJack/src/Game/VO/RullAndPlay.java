package Game.VO;

import java.util.ArrayList; 
import java.util.Collections;

public class RullAndPlay {
	
	CardDeck deck = new CardDeck();
	ArrayList<Card> list = deck.call_deck();
	
	public ArrayList<Card> play() {		
		Card card = new Card();
		Collections.shuffle(list);
		ArrayList<Card> landom_card = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			landom_card.add(list.get(i));
		}
		return landom_card;		
	}
	
	public int grading(int user_count, int dealer_count) {
		//return 1 == À¯Àú½Â,  2 == µô·¯½Â, 3 == ºñ±è
		//21Á¡À» ³Ñ¾úÀ» ¶§
		if(user_count > 21 && dealer_count > 21) {
			return 3;
		} else if(user_count > 21) {
			return 2;
		} else if(dealer_count > 21) {
			return 1;
		}
		
		if(dealer_count == user_count) {
			return 3;
		} else if(dealer_count < 22 && dealer_count > user_count) {
			return 2;
		} else if(user_count < 22 && user_count > dealer_count) {
			return 1;
		}
		
		return 77;
	}
	
	public void clearAll() {
		for(int i=0; i<24; i++) {
			System.out.println("");
		}
	}
	public void clearMedium() {
		for(int i=0; i<12; i++) {
			System.out.println("");
		}
	}
	public void clearSmall() {
		for(int i=0; i<7; i++) {
			System.out.println("");
		}
	}
	
	

}
