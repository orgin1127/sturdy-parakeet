package Game.VO;

import java.util.ArrayList;

public class CardDeck {
	
	Card card1 = new Card("♠", "1", 1);
	Card card2 = new Card("♠", "2", 2);
	Card card3 = new Card("♠", "3", 3);
	Card card4 = new Card("♠", "4", 4);
	Card card5 = new Card("♠", "5", 5);
	Card card6 = new Card("♠", "6", 6);
	Card card7 = new Card("♠", "7", 7);
	Card card8 = new Card("♠", "8", 8);
	Card card9 = new Card("♠", "9", 9);
	Card card10 = new Card("♠", "10", 10);
	Card card11 = new Card("♠", "J", 10);
	Card card12 = new Card("♠", "Q", 10);
	Card card13 = new Card("♠", "K", 10);
	
	Card card14 = new Card("♣", "1", 1);
	Card card15 = new Card("♣", "2", 2);
	Card card16 = new Card("♣", "3", 3);
	Card card17 = new Card("♣", "4", 4);
	Card card18 = new Card("♣", "5", 5);
	Card card19 = new Card("♣", "6", 6);
	Card card20 = new Card("♣", "7", 7);
	Card card21 = new Card("♣", "8", 8);
	Card card22 = new Card("♣", "9", 9);
	Card card23 = new Card("♣", "10", 10);
	Card card24 = new Card("♣", "J", 10);
	Card card25 = new Card("♣", "Q", 10);
	Card card26 = new Card("♣", "K", 10);
	
	Card card27 = new Card("♥", "1", 1);
	Card card28 = new Card("♥", "2", 2);
	Card card29 = new Card("♥", "3", 3);
	Card card30 = new Card("♥", "4", 4);
	Card card31 = new Card("♥", "5", 5);
	Card card32 = new Card("♥", "6", 6);
	Card card33 = new Card("♥", "7", 7);
	Card card34 = new Card("♥", "8", 8);
	Card card35 = new Card("♥", "9", 9);
	Card card36 = new Card("♥", "10", 10);
	Card card37 = new Card("♥", "J", 10);
	Card card38 = new Card("♥", "Q", 10);
	Card card39 = new Card("♥", "K", 10);
	
	Card card40 = new Card("◆", "1", 1);
	Card card41 = new Card("◆", "2", 2);
	Card card42 = new Card("◆", "3", 3);
	Card card43 = new Card("◆", "4", 4);
	Card card44 = new Card("◆", "5", 5);
	Card card45 = new Card("◆", "6", 6);
	Card card46 = new Card("◆", "7", 7);
	Card card47 = new Card("◆", "8", 8);
	Card card48 = new Card("◆", "9", 9);
	Card card49 = new Card("◆", "10", 10);
	Card card50 = new Card("◆", "J", 10);
	Card card51 = new Card("◆", "Q", 10);
	Card card52 = new Card("◆", "K", 10);
	
	public ArrayList<Card> call_deck() {
		
		ArrayList<Card> deck = new ArrayList<>();
		deck.add(card1);
		deck.add(card2);
		deck.add(card3);
		deck.add(card4);
		deck.add(card5);
		deck.add(card6);
		deck.add(card7);
		deck.add(card8);
		deck.add(card9);
		deck.add(card10);
		deck.add(card11);
		deck.add(card12);
		deck.add(card13);
		
		deck.add(card14);
		deck.add(card15);
		deck.add(card16);
		deck.add(card17);
		deck.add(card18);
		deck.add(card19);
		deck.add(card20);
		deck.add(card21);
		deck.add(card22);
		deck.add(card23);
		deck.add(card24);
		deck.add(card25);
		deck.add(card26);
		
		deck.add(card27);
		deck.add(card28);
		deck.add(card29);
		deck.add(card30);
		deck.add(card31);
		deck.add(card32);
		deck.add(card33);
		deck.add(card34);
		deck.add(card35);
		deck.add(card36);
		deck.add(card37);
		deck.add(card38);
		deck.add(card39);
		
		deck.add(card40);
		deck.add(card41);
		deck.add(card42);
		deck.add(card43);
		deck.add(card44);
		deck.add(card45);
		deck.add(card46);
		deck.add(card47);
		deck.add(card48);
		deck.add(card49);
		deck.add(card50);
		deck.add(card51);
		deck.add(card52);
		
		return deck;
	}
	
}
