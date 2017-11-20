package User.VO;

public class N2 extends Word {
	private String typeN2;

	public String getTypeN2() {return typeN2;}
	public void setTypeN2(String typeN2) {this.typeN2 = typeN2;}
	public N2() {}
	public N2(int wordnumber, String kanji, String yomigana, String meaning, String typeN2) {
		super(wordnumber, kanji, yomigana, meaning);
		this.typeN2 = typeN2;
	}
}
