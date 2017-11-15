package User.VO;

public class N3 {
	
	private int wordnumberN3;
	private String kanjiN3;
	private String yomiganaN3;
	private String meaningN3;
	
	public N3(){}
	
	public N3(int wordnumberN3, String kanjiN3, String yomiganaN3, String meaningN3) {
		this.wordnumberN3 = wordnumberN3;
		this.kanjiN3 = kanjiN3;
		this.yomiganaN3 = yomiganaN3;
		this.meaningN3 = meaningN3;
	}
	
	public N3(String kanjiN3, String yomiganaN3, String meaningN3) {
		this.kanjiN3 = kanjiN3;
		this.yomiganaN3 = yomiganaN3;
		this.meaningN3 = meaningN3;
	}

	public int getWordnumberN3() {
		return wordnumberN3;
	}

	public void setWordnumberN3(int wordnumberN3) {
		this.wordnumberN3 = wordnumberN3;
	}

	public String getKanjiN3() {
		return kanjiN3;
	}

	public void setKanjiN3(String kanjiN3) {
		this.kanjiN3 = kanjiN3;
	}

	public String getYomiganaN3() {
		return yomiganaN3;
	}

	public void setYomiganaN3(String yomiganaN3) {
		this.yomiganaN3 = yomiganaN3;
	}

	public String getMeaningN3() {
		return meaningN3;
	}

	public void setMeaningN3(String meaningN3) {
		this.meaningN3 = meaningN3;
	}
	
	@Override
	public String toString() {
		String s = "漢字番号  : "+wordnumberN3+", 漢字  : "+kanjiN3+
				", よみがな  : "+yomiganaN3+", 意味  : "+meaningN3;
		return s;
	}
	

}
