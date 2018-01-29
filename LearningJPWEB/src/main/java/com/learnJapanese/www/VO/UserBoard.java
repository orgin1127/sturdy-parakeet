package com.learnJapanese.www.VO;

public class UserBoard {
	
	private int boardNum;
	private String userID;
	private String title;
	private String content;
	private int hits;
	private String writedDate;
	private String savedFile;
	private String origianlFile;
	
	public int getBoardNum() {return boardNum;}
	public void setBoardNum(int boardNum) {this.boardNum = boardNum;}
	public String getUserID() {return userID;}
	public void setUserID(String userID) {this.userID = userID;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public int getHits() {return hits;}
	public void setHits(int hits) {this.hits = hits;}
	public String getWritedDate() {return writedDate;}
	public void setWritedDate(String writedDate) {this.writedDate = writedDate;}
	public String getSavedFile() {return savedFile;}
	public void setSavedFile(String savedFile) {this.savedFile = savedFile;}
	public String getOrigianlFile() {return origianlFile;}
	public void setOrigianlFile(String origianlFile) {this.origianlFile = origianlFile;}
	
	public UserBoard() {	}
	
	public UserBoard(String userID, String title, String content) {
		this.userID = userID;
		this.title = title;
		this.content = content;
	}
	
	public UserBoard(String userID, String title, String content, String savedFile, String origianlFile) {
		this.userID = userID;
		this.title = title;
		this.content = content;
		this.savedFile = savedFile;
		this.origianlFile = origianlFile;
	}
	
	public UserBoard(int boardNum, String userID, String title, String content, int hits, String writedDate,
			String savedFile, String origianlFile) {
		this.boardNum = boardNum;
		this.userID = userID;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.writedDate = writedDate;
		this.savedFile = savedFile;
		this.origianlFile = origianlFile;
	}
	@Override
	public String toString() {
		return "UserBoard [boardNum=" + boardNum + ", userID=" + userID + ", title=" + title + ", content=" + content
				+ ", hits=" + hits + ", writedDate=" + writedDate + ", savedFile=" + savedFile + ", origianlFile="
				+ origianlFile + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNum;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + hits;
		result = prime * result + ((origianlFile == null) ? 0 : origianlFile.hashCode());
		result = prime * result + ((savedFile == null) ? 0 : savedFile.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		result = prime * result + ((writedDate == null) ? 0 : writedDate.hashCode());
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
		UserBoard other = (UserBoard) obj;
		if (boardNum != other.boardNum)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (hits != other.hits)
			return false;
		if (origianlFile == null) {
			if (other.origianlFile != null)
				return false;
		} else if (!origianlFile.equals(other.origianlFile))
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
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		if (writedDate == null) {
			if (other.writedDate != null)
				return false;
		} else if (!writedDate.equals(other.writedDate))
			return false;
		return true;
	}

}
