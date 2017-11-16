package User.VO;

public class CustomMemorize {
	private int customWordNumber;
	private int accountNumber;
	private String customKanji;
	private String customYomigana;
	private String customMeaning;
	
	public int getCustomWordNumber() {return customWordNumber;}
	public void setCustomWordNumber(int customWordNumber) {this.customWordNumber = customWordNumber;}
	public int getAccountNumber() {return accountNumber;}
	public void setAccountNumber(int accountNumber) {this.accountNumber = accountNumber;}
	public String getCustomKanji() {return customKanji;}
	public void setCustomKanji(String customKanji) {this.customKanji = customKanji;}
	public String getCustomYomigana() {return customYomigana;}
	public void setCustomYomigana(String customYomigana) {this.customYomigana = customYomigana;}
	public String getCustomMeaning() {return customMeaning;}
	public void setCustomMeaning(String customMeaning) {this.customMeaning = customMeaning;}
	
	public CustomMemorize() {}
	public CustomMemorize(int accountNumber, String customKanji, String customYomigana, String customMeaning) {
		this.accountNumber = accountNumber;
		this.customKanji = customKanji;
		this.customYomigana = customYomigana;
		this.customMeaning = customMeaning;
	}
	public CustomMemorize(int customWordNumber, int accountNumber, String customKanji, String customYomigana,
			String customMeaning) {
		super();
		this.customWordNumber = customWordNumber;
		this.accountNumber = accountNumber;
		this.customKanji = customKanji;
		this.customYomigana = customYomigana;
		this.customMeaning = customMeaning;
	}
	@Override
	public String toString() {
		String s = ", 漢字  : "+customKanji+
				", よみがな  : "+customYomigana+", 意味  : "+customMeaning;
		return s;
	} 
	
	
}
