package User.VO;

public class Word {
	private int wordnumber;
    private String kanji;
    private String yomigana;
    private String meaning;
    
	public int getWordnumber() {return wordnumber;}
	public void setWordnumber(int wordnumber) {this.wordnumber = wordnumber;}
	public String getKanji() {return kanji;}
	public void setKanji(String kanji) {this.kanji = kanji;}
	public String getYomigana() {return yomigana;}
	public void setYomigana(String yomigana) {this.yomigana = yomigana;}
	public String getMeaning() {return meaning;}
	public void setMeaning(String meaning) {this.meaning = meaning;}
	
	public Word() {}
	
	public Word(String kanji, String yomigana, String meaning) {
		this.kanji = kanji;
		this.yomigana = yomigana;
		this.meaning = meaning;
	}
	public Word(int wordnumber, String kanji, String yomigana, String meaning) {
		this.wordnumber = wordnumber;
		this.kanji = kanji;
		this.yomigana = yomigana;
		this.meaning = meaning;
	}
	@Override
	public String toString() {
		return "単語番号：" + wordnumber + ", 漢字：" + kanji + ", よみがな：" + yomigana + ", 意味：" + meaning;
	}
	
	public String showWords() {
		return "漢字：" + kanji + ", よみがな：" + yomigana + ", 意味：" + meaning;
	}
    
    
}
