package User.VO;

public class N1 extends Word {
	private String typeN1;

	public String getTypeN1() {return typeN1;}
	public void setTypeN1(String type) {this.typeN1 = type;}
	
	public N1() {}
	
	
	
	public N1(String kanji, String yomigana, String meaning,String typeN1) {
		super(kanji, yomigana, meaning);
		this.typeN1 = typeN1;
	}
	
	public N1(int wordnumber, String kanji, String yomigana, String meaning,String typeN1) {
		super(wordnumber, kanji, yomigana, meaning);
		this.typeN1 = typeN1;
	}

}
