package study.pbj.vo;

public class gameInfoVO {
	
	//field
	private int gameResultNumber;
	private int accountNumber;
	private int money;
	private int winCount;
	private int loseCount;
	private int gameCount;
	
	//getter, setter
	public int getGameResultNumber() {return gameResultNumber;}
	public void setGameResultNumber(int gameResultNumber) {this.gameResultNumber = gameResultNumber;}
	public int getAccountNumber() {return accountNumber;}
	public void setAccountNumber(int accountNumber) {this.accountNumber = accountNumber;}
	public int getMoney() {return money;}
	public void setMoney(int money) {this.money = money;}
	public int getWinCount() {return winCount;}
	public void setWinCount(int winCount) {this.winCount = winCount;}
	public int getLoseCount() {return loseCount;}
	public void setLoseCount(int loseCount) {this.loseCount = loseCount;}
	public int getGameCount() {return gameCount;}
	public void setGameCount(int gameCount) {this.gameCount = gameCount;}
	
	//default constructor
	public gameInfoVO() {
	}
	
	//constructors
	public gameInfoVO(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public gameInfoVO(int accountNumber, int money, int winCount, int loseCount, int gameCount) {
		this.accountNumber = accountNumber;
		this.money = money;
		this.winCount = winCount;
		this.loseCount = loseCount;
		this.gameCount = gameCount;
	}
	public gameInfoVO(int gameResultNumber, int accountNumber, int money, int winCount, int loseCount, int gameCount) {
		this.gameResultNumber = gameResultNumber;
		this.accountNumber = accountNumber;
		this.money = money;
		this.winCount = winCount;
		this.loseCount = loseCount;
		this.gameCount = gameCount;
	}
	
	@Override
	public String toString() {
		return "gameInfoVO [gameResultNumber=" + gameResultNumber + ", accountNumber=" + accountNumber + ", money="
				+ money + ", winCount=" + winCount + ", loseCount=" + loseCount + ", gameCount=" + gameCount + "]";
	}
	
}
