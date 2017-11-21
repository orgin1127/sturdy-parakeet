package User.VO;

public class BlackJackGameVO {
	private int accountNumber;
	private int money;
	private int winCount;
	private int loseCount;
	private String pattern;
	private String numbers;
	
	public int getAccountNumber() {return accountNumber;}
	public void setAccountNumber(int accountNumber) {this.accountNumber = accountNumber;}
	public int getMoney() {return money;}
	public void setMoney(int money) {this.money = money;}
	public int getWinCount() {return winCount;}
	public void setWinCount(int winCount) {this.winCount = winCount;}
	public int getLoseCount() {return loseCount;}
	public void setLoseCount(int loseCount) {this.loseCount = loseCount;}
	public String getPattern() {return pattern;}
	public void setPattern(String pattern) {this.pattern = pattern;}
	public String getNumbers() {return numbers;}
	public void setNumbers(String numbers) {this.numbers = numbers;}
	
	public BlackJackGameVO() {}
	
	public BlackJackGameVO(String pattern, String numbers) {
		this.pattern = pattern;
		this.numbers = numbers;
	}
	
	public BlackJackGameVO(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public BlackJackGameVO(int accountNumber, int money, int winCount, int loseCount) {
		this.accountNumber = accountNumber;
		this.money = money;
		this.winCount = winCount;
		this.loseCount = loseCount;
	}
	
	public BlackJackGameVO(int accountNumber, int money, int winCount, int loseCount, String pattern, String numbers) {
		super();
		this.accountNumber = accountNumber;
		this.money = money;
		this.winCount = winCount;
		this.loseCount = loseCount;
		this.pattern = pattern;
		this.numbers = numbers;
	}
	
	public String openCard() {
		return pattern+"/"+numbers;
	}
	
	@Override
	public String toString() {
		return "BlackJackGameVO [accountNumber=" + accountNumber + ", money=" + money + ", winCount=" + winCount
				+ ", loseCount=" + loseCount + ", pattern=" + pattern + ", numbers=" + numbers + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + loseCount;
		result = prime * result + (int) (money ^ (money >>> 32));
		result = prime * result + ((numbers == null) ? 0 : numbers.hashCode());
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		result = prime * result + winCount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlackJackGameVO other = (BlackJackGameVO) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (loseCount != other.loseCount)
			return false;
		if (money != other.money)
			return false;
		if (numbers == null) {
			if (other.numbers != null)
				return false;
		} else if (!numbers.equals(other.numbers))
			return false;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.equals(other.pattern))
			return false;
		if (winCount != other.winCount)
			return false;
		return true;
	}



	
	
	

}
