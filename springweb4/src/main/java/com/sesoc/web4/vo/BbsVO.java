package com.sesoc.web4.vo;

public class BbsVO {
	
	private int bbsnum;
	private String userID;
	private String password;
	private String content;
	private String inputdate;
	
	public int getBbsnum() {return bbsnum;}
	public void setBbsnum(int bbsnum) {this.bbsnum = bbsnum;}
	public String getUserID() {return userID;}
	public void setUserID(String userID) {this.userID = userID;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public String getInputdate() {return inputdate;}
	public void setInputdate(String inputdate) {this.inputdate = inputdate;}
	
	public BbsVO() {}
	
	public BbsVO(String userID, String password, String content) {
		this.userID = userID;
		this.password = password;
		this.content = content;
	}
	
	public BbsVO(int bbsnum, String userID, String password, String content, String inputdate) {
		this.bbsnum = bbsnum;
		this.userID = userID;
		this.password = password;
		this.content = content;
		this.inputdate = inputdate;
	}
	@Override
	public String toString() {
		return "BbsVO [bbsnum=" + bbsnum + ", userID=" + userID + ", password=" + password + ", content=" + content
				+ ", inputdate=" + inputdate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bbsnum;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((inputdate == null) ? 0 : inputdate.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		BbsVO other = (BbsVO) obj;
		if (bbsnum != other.bbsnum)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (inputdate == null) {
			if (other.inputdate != null)
				return false;
		} else if (!inputdate.equals(other.inputdate))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}
	
}
