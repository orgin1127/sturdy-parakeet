package User.VO;

public class N3 extends Word{
	
	private String typeN3;

	public String getTypeN2() {return typeN3;}
	public void setTypeN2(String typeN2) {this.typeN3 = typeN2;}
	
	public N3() {}
	public N3(int wordnumber, String kanji, String yomigana, String meaning, String typeN3) {
		super(wordnumber, kanji, yomigana, meaning);
		this.typeN3 = typeN3;
	}

}
