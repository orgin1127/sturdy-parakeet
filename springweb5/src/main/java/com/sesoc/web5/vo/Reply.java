package com.sesoc.web5.vo;

public class Reply {
	private int replynum;
	private int boardnum;
	private String custid;
	private String replyContent;
	private String inputdate;
	private int replyCount;
	
	public int getReplynum() {return replynum;}
	public void setReplynum(int replynum) {this.replynum = replynum;}
	public int getBoardnum() {return boardnum;}
	public void setBoardnum(int boardnum) {this.boardnum = boardnum;}
	public String getCustid() {return custid;}
	public void setCustid(String custid) {this.custid = custid;}
	public String getReplyContent() {return replyContent;}
	public void setReplyContent(String replyContent) {this.replyContent = replyContent;}
	public String getInputdate() {return inputdate;}
	public void setInputdate(String inputdate) {this.inputdate = inputdate;}
	public int getReplyCount() {return replyCount;}
	public void setReplyCount(int replyCount) {this.replyCount = replyCount;}
	
	public Reply() {}
	
	public Reply(int boardnum) {
		this.boardnum = boardnum;
	}
	
	public Reply(int replynum, int boardnum) {
		this.replynum = replynum;
		this.boardnum = boardnum;
	}
	
	public Reply(int replynum, int boardnum, String custid, String replyContent, String inputdate) {
		this.replynum = replynum;
		this.boardnum = boardnum;
		this.custid = custid;
		this.replyContent = replyContent;
		this.inputdate = inputdate;
	}
	
	public Reply(int replynum, int boardnum, String custid, String replyContent, String inputdate, int replyCount) {
		this.replynum = replynum;
		this.boardnum = boardnum;
		this.custid = custid;
		this.replyContent = replyContent;
		this.inputdate = inputdate;
		this.replyCount = replyCount;
	}

	@Override
	public String toString() {
		return "Reply [replynum=" + replynum + ", boardnum=" + boardnum + ", custid=" + custid + ", replyContent="
				+ replyContent + ", inputdate=" + inputdate + ", replyCount=" + replyCount + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardnum;
		result = prime * result + ((custid == null) ? 0 : custid.hashCode());
		result = prime * result + ((inputdate == null) ? 0 : inputdate.hashCode());
		result = prime * result + ((replyContent == null) ? 0 : replyContent.hashCode());
		result = prime * result + replynum;
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
		Reply other = (Reply) obj;
		if (boardnum != other.boardnum)
			return false;
		if (custid == null) {
			if (other.custid != null)
				return false;
		} else if (!custid.equals(other.custid))
			return false;
		if (inputdate == null) {
			if (other.inputdate != null)
				return false;
		} else if (!inputdate.equals(other.inputdate))
			return false;
		if (replyContent == null) {
			if (other.replyContent != null)
				return false;
		} else if (!replyContent.equals(other.replyContent))
			return false;
		if (replynum != other.replynum)
			return false;
		return true;
	}
	
}
