package User.VO;

public class N2 {
	private int wordnumberN2;
	private String kanjiN2;
	private String yomiganaN2;
	private String meaningN2;
	
	public N2(){}
	
	public N2(int wordnumberN2, String kanjiN2, String yomiganaN2, String meaningN2) {
		this.wordnumberN2 = wordnumberN2;
		this.kanjiN2 = kanjiN2;
		this.yomiganaN2 = yomiganaN2;
		this.meaningN2 = meaningN2;
	}
	
	public N2(String kanjiN2, String yomiganaN2, String meaningN2) {
		super();
		this.kanjiN2 = kanjiN2;
		this.yomiganaN2 = yomiganaN2;
		this.meaningN2 = meaningN2;
	}

	public int getWordnumberN2() {
		return wordnumberN2;
	}

	public void setWordnumberN2(int wordnumberN2) {
		this.wordnumberN2 = wordnumberN2;
	}

	public String getKanjiN2() {
		return kanjiN2;
	}

	public void setKanjiN2(String kanjiN2) {
		this.kanjiN2 = kanjiN2;
	}

	public String getYomiganaN2() {
		return yomiganaN2;
	}

	public void setYomiganaN2(String yomiganaN2) {
		this.yomiganaN2 = yomiganaN2;
	}

	public String getMeaningN2() {
		return meaningN2;
	}

	public void setMeaningN2(String meaningN2) {
		this.meaningN2 = meaningN2;
	}
	
	@Override
	public String toString() {
		String s = "漢字番号  : "+wordnumberN2+", 漢字  : "+kanjiN2+
				", よみがな  : "+yomiganaN2+", 意味  : "+meaningN2;
		return s;
	}
	
}
