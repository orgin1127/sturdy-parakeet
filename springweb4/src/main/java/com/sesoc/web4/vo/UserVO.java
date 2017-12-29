package com.sesoc.web4.vo;

public class UserVO {
	
	private int userNum;
	private String userID;
	private String userPassword;
	
	public int getUserNum() {return userNum;}
	public void setUserNum(int userNum) {this.userNum = userNum;}
	public String getUserID() {return userID;}
	public void setUserID(String userID) {this.userID = userID;}
	public String getUserPassword() {return userPassword;}
	public void setUserPassword(String userPassword) {this.userPassword = userPassword;}
	
	public UserVO() {}
	
	public UserVO(String userID, String userPassword) {
		this.userID = userID;
		this.userPassword = userPassword;
	}
	
	public UserVO(int userNum, String userID, String userPassword) {
		this.userNum = userNum;
		this.userID = userID;
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "UserVO [userNum=" + userNum + ", userID=" + userID + ", userPassword=" + userPassword + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		result = prime * result + userNum;
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
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
		UserVO other = (UserVO) obj;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		if (userNum != other.userNum)
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}
}
