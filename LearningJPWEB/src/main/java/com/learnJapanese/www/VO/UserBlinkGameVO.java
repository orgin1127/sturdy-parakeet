package com.learnJapanese.www.VO;

public class UserBlinkGameVO {
	
	private int gameNum;
	private String userID;
	private int playCount;
	private int highScore;
	private int maxCombo;
	
	public int getGameNum() {
		return gameNum;
	}
	public void setGameNum(int gameNum) {
		this.gameNum = gameNum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getPlayCount() {
		return playCount;
	}
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	public int getHighScore() {
		return highScore;
	}
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	public int getMaxCombo() {
		return maxCombo;
	}
	public void setMaxCombo(int maxCombo) {
		this.maxCombo = maxCombo;
	}
	
	public UserBlinkGameVO() {}
	
	public UserBlinkGameVO(String userID) {
		this.userID = userID;
	}
	
	public UserBlinkGameVO(int playCount, int highScore, int maxCombo) {
		this.playCount = playCount;
		this.highScore = highScore;
		this.maxCombo = maxCombo;
	}
	
	public UserBlinkGameVO(int gameNum, String userID, int playCount, int highScore, int maxCombo) {
		this.gameNum = gameNum;
		this.userID = userID;
		this.playCount = playCount;
		this.highScore = highScore;
		this.maxCombo = maxCombo;
	}
	
	@Override
	public String toString() {
		return "UserBlinkGameVO [gameNum=" + gameNum + ", userID=" + userID + ", playCount=" + playCount
				+ ", highScore=" + highScore + ", maxCombo=" + maxCombo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameNum;
		result = prime * result + highScore;
		result = prime * result + maxCombo;
		result = prime * result + playCount;
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
		UserBlinkGameVO other = (UserBlinkGameVO) obj;
		if (gameNum != other.gameNum)
			return false;
		if (highScore != other.highScore)
			return false;
		if (maxCombo != other.maxCombo)
			return false;
		if (playCount != other.playCount)
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}
	
}
