package User.VO;

public class UserInfomation {
	private int accountnumber;
	private String userID;
	private String password;
	private String createdate;
	
	public UserInfomation() {}

	public UserInfomation(String userID, String password) {
		this.userID = userID;
		this.password = password;
	}
	public UserInfomation(int accountnumber, String userID, String password, String createdate) {
		this.accountnumber = accountnumber;
		this.userID = userID;
		this.password = password;
		this.createdate = createdate;
	}

	
	
	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		String s = "会員番号 : "+accountnumber+", アイディー : "+userID
				+", 暗証番号 : "+password+", 登録日 : "+createdate;
		return s;
	} 
	
	
	
	
	
	
}



