package com.sesoc.web4.vo;

public class BbsVO {
	
	private int bbsnum;
	private String name;
	private String password;
	private String content;
	private String inputdate;
	
	public int getBbsnum() {return bbsnum;}
	public void setBbsnum(int bbsnum) {this.bbsnum = bbsnum;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public String getInputdate() {return inputdate;}
	public void setInputdate(String inputdate) {this.inputdate = inputdate;}
	
	public BbsVO() {
	}
	
	public BbsVO(String name, String password, String content) {
		this.name = name;
		this.password = password;
		this.content = content;
	}
	
	public BbsVO(int bbsnum, String password) {
		this.bbsnum = bbsnum;
		this.password = password;
	}
	
	public BbsVO(int bbsnum, String name, String password, String content, String inputdate) {
		this.bbsnum = bbsnum;
		this.name = name;
		this.password = password;
		this.content = content;
		this.inputdate = inputdate;
	}
	@Override
	public String toString() {
		return "BbsVO [bbsnum=" + bbsnum + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", inputdate=" + inputdate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bbsnum;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((inputdate == null) ? 0 : inputdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
