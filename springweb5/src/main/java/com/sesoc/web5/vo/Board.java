package com.sesoc.web5.vo;

public class Board {
	
	private int boardnum;
	private String custid;
	private String title;
	private String content;
	private String inputdate;
	private int hits;
	private String originalFile;
	private String savedFile;
	private String ip;
	
	public int getBoardnum() {return boardnum;}
	public void setBoardnum(int boardnum) {this.boardnum = boardnum;}
	public String getCustid() {return custid;}
	public void setCustid(String custid) {this.custid = custid;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public String getInputdate() {return inputdate;}
	public void setInputdate(String inputdate) {this.inputdate = inputdate;}
	public int getHits() {return hits;}
	public void setHits(int hits) {this.hits = hits;}
	public String getOriginalFile() {return originalFile;}
	public void setOriginalFile(String originalFile) {this.originalFile = originalFile;}
	public String getSavedFile() {return savedFile;}
	public void setSavedFile(String savedFile) {this.savedFile = savedFile;}
	public String getIp() {return ip;}
	public void setIp(String ip) {this.ip = ip;}
	
	public Board() {}
	
	public Board(int boardnum, String custid) {
		this.boardnum = boardnum;
		this.custid = custid;
	}
	
	public Board(int boardnum, String custid, String title, String content) {
		this.boardnum = boardnum;
		this.custid = custid;
		this.title = title;
		this.content = content;
	}
	
	public Board(String custid, String title, String content, String ip) {
		this.custid = custid;
		this.title = title;
		this.content = content;
		this.ip = ip;
	}
	
	public Board(int boardnum, String custid, String title, String content, String inputdate, int hits,
			String originalFile, String savedFile, String ip) {
		this.boardnum = boardnum;
		this.custid = custid;
		this.title = title;
		this.content = content;
		this.inputdate = inputdate;
		this.hits = hits;
		this.originalFile = originalFile;
		this.savedFile = savedFile;
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "Board [boardnum=" + boardnum + ", custid=" + custid + ", title=" + title + ", content=" + content
				+ ", inputdate=" + inputdate + ", hits=" + hits + ", originalFile=" + originalFile + ", savedFile="
				+ savedFile + ", ip=" + ip + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardnum;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((custid == null) ? 0 : custid.hashCode());
		result = prime * result + hits;
		result = prime * result + ((inputdate == null) ? 0 : inputdate.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((originalFile == null) ? 0 : originalFile.hashCode());
		result = prime * result + ((savedFile == null) ? 0 : savedFile.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Board other = (Board) obj;
		if (boardnum != other.boardnum)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (custid == null) {
			if (other.custid != null)
				return false;
		} else if (!custid.equals(other.custid))
			return false;
		if (hits != other.hits)
			return false;
		if (inputdate == null) {
			if (other.inputdate != null)
				return false;
		} else if (!inputdate.equals(other.inputdate))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (originalFile == null) {
			if (other.originalFile != null)
				return false;
		} else if (!originalFile.equals(other.originalFile))
			return false;
		if (savedFile == null) {
			if (other.savedFile != null)
				return false;
		} else if (!savedFile.equals(other.savedFile))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
