package User.VO;

public class N1 {
	
    private int wordnumberN1;
    private String kanjiN1;
    private String yomiganaN1;
    private String meaningN1;
    
    public N1() {}    

	public N1(String kanjiN1, String yomiganaN1, String meaningN1) {
		super();
		this.kanjiN1 = kanjiN1;
		this.yomiganaN1 = yomiganaN1;
		this.meaningN1 = meaningN1;
	}
	
	public N1(int wordnumberN1, String kanjiN1, String yomiganaN1, String meaningN1) {
		this.wordnumberN1 = wordnumberN1;
		this.kanjiN1 = kanjiN1;
		this.yomiganaN1 = yomiganaN1;
		this.meaningN1 = meaningN1;
	}

	public int getWordnumberN1() {
		return wordnumberN1;
	}
	public void setWordnumberN1(int wordnumberN1) {
		this.wordnumberN1 = wordnumberN1;
	}
	public String getKanjiN1() {
		return kanjiN1;
	}
	public void setKanjiN1(String kanjiN1) {
		this.kanjiN1 = kanjiN1;
	}
	public String getYomiganaN1() {
		return yomiganaN1;
	}
	public void setYomiganaN1(String yomiganaN1) {
		this.yomiganaN1 = yomiganaN1;
	}
	public String getMeaningN1() {
		return meaningN1;
	}
	public void setMeaningN1(String meaningN1) {
		this.meaningN1 = meaningN1;
	}

	@Override
	public String toString() {
		String s = "漢字番号  : "+wordnumberN1+", 漢字  : "+kanjiN1+
				", よみがな  : "+yomiganaN1+", 意味  : "+meaningN1;
		return s;
	} 
    
	

}
