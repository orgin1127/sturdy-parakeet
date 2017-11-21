package User.VO;

public class BlinkGameVO {
	private int blinkGameNumber;
	private int accountNumber;
	private int clearWordCount;
	private int maxCombo;
	private int highScore;
	private String userID;
	
	public int getBlinkGameNumber() {return blinkGameNumber;}
	public void setBlinkGameNumber(int blinkGameNumber) {this.blinkGameNumber = blinkGameNumber;}
	public int getAccountNumber() {return accountNumber;}
	public void setAccountNumber(int accountNumber) {this.accountNumber = accountNumber;}
	public int getClearWordCount() {return clearWordCount;}
	public void setClearWordCount(int clearWordCount) {this.clearWordCount = clearWordCount;}
	public int getMaxCombo() {return maxCombo;}
	public void setMaxCombo(int maxCombo) {this.maxCombo = maxCombo;}
	public int getHighScore() {return highScore;}
	public void setHighScore(int highScore) {this.highScore = highScore;}
	public String getUserID() {return userID;}
	public void setUserID(String userID) {this.userID = userID;}
	
	public BlinkGameVO() {}
	
	public BlinkGameVO(int blinkGameNumber, int accountNumber
						, int clearWordCount, int maxCombo, int highScore) {
		this.blinkGameNumber = blinkGameNumber;
		this.accountNumber = accountNumber;
		this.clearWordCount = clearWordCount;
		this.maxCombo = maxCombo;
		this.highScore = highScore;
	}
	
	public BlinkGameVO(int accountNumber, int clearWordCount, int maxCombo, int highScore) {
		this.accountNumber = accountNumber;
		this.clearWordCount = clearWordCount;
		this.maxCombo = maxCombo;
		this.highScore = highScore;
	}
	public BlinkGameVO(int blinkGameNumber, int accountNumber) {
		this.blinkGameNumber = blinkGameNumber;
		this.accountNumber = accountNumber;
	}
	public BlinkGameVO(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	public BlinkGameVO(int accountNumber, int clearWordCount, int maxCombo, int highScore, String userID) {
		this.accountNumber = accountNumber;
		this.clearWordCount = clearWordCount;
		this.maxCombo = maxCombo;
		this.highScore = highScore;
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "BlinkGameVO [blinkGameNumber=" + blinkGameNumber + ", accountNumber=" + accountNumber + 
				", clearWordCount=" + clearWordCount + ", maxCombo=" + maxCombo + ", highScore=" + highScore+ "]";
	}
	
	public String showRanking() {
		return "ユーザID："+userID+", "+"アカウントナンバー："+accountNumber+", クリアした単語の数：" 
				+ clearWordCount + ", MAXCOMBO：" + maxCombo + ", HIGHSCORE：" + highScore;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlinkGameVO other = (BlinkGameVO) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (blinkGameNumber != other.blinkGameNumber)
			return false;
		if (clearWordCount != other.clearWordCount)
			return false;
		if (highScore != other.highScore)
			return false;
		if (maxCombo != other.maxCombo)
			return false;
		return true;
	}
}
