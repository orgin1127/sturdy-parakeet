package Game.VO;

import java.util.ArrayList;

public class Card {
	
	private String pattern;
	private String card_num;
	private int point;
	
	public Card() {}
	
	public Card(int point) {
		this.point = point;
	}
	
	public Card(String pattern, String card_num, int point) {
		this.pattern = pattern;
		this.card_num = card_num;
		this.point = point;
	}
	
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getCard_num() {
		return card_num;
	}
	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}	

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		String s = pattern+card_num;
		return s;
	}
		
	
	
	

	

	
	
	
	
		

}
