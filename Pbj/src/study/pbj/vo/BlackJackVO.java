package study.pbj.vo;

public class BlackJackVO {
	
	//field
	private int accountNumber;
	private String userId;
	private String password;
	private String createDate;
	private int levels;
	
	//getter, setter
	public int getAccountNumber() {return accountNumber;}
	public void setAccountNumber(int accountNumber) {this.accountNumber = accountNumber;}
	public String getUserId() {return userId;}
	public void setUserId(String userId) {this.userId = userId;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getCreateDate() {return createDate;}
	public void setCreateDate(String createDate) {this.createDate = createDate;}
	public int getLevels() {return levels;}
	public void setLevels(int levels) {this.levels = levels;}
	
	//default constructor
	public BlackJackVO() {}
	
	//constructors
	public BlackJackVO(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	public BlackJackVO(int accountNumber, String userId, String password, String createDate, int levels) {
		this.accountNumber = accountNumber;
		this.userId = userId;
		this.password = password;
		this.createDate = createDate;
		this.levels = levels;
	}
	@Override
	public String toString() {
		return "BlackJackVO [accountNumber=" + accountNumber + ", userId=" + userId + ", password=" + password
				+ ", createDate=" + createDate + ", levels=" + levels + "]";
	}

}
