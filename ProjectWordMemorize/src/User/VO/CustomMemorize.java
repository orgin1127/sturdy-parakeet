package User.VO;

public class CustomMemorize extends Word {
	private int customWordNumber;
	private int accountNumber;
	private String typeCustom;
	
	public int getCustomWordNumber() {return customWordNumber;}
	public void setCustomWordNumber(int customWordNumber) {this.customWordNumber = customWordNumber;}
	public int getAccountNumber() {return accountNumber;}
	public void setAccountNumber(int accountNumber) {this.accountNumber = accountNumber;}

	
	public CustomMemorize() {}
	public CustomMemorize(String kanji, String yomigana, String meaning, int accountNumber) {
		super(kanji, yomigana, meaning);
		this.accountNumber = accountNumber;
	}
	public CustomMemorize(int wordnumber, String kanji, String yomigana, String meaning, int accountNumber) {
		super(wordnumber, kanji, yomigana, meaning);
		this.accountNumber = accountNumber;
	}
	@Override
	public String showWords() {
		return super.showWords();
	}
	
	
}
