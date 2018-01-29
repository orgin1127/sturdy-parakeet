package com.learnJapanese.www.VO;

public class Word {
	
	private int wordNum;
	private String word;
	private String yomigana;
	private String meaning;
	private String linkAddress;
	private String wordLevel;
	
	public int getWordNum() {return wordNum;}
	public void setWordNum(int wordNum) {this.wordNum = wordNum;}
	public String getWord() {return word;}
	public void setWord(String word) {this.word = word;}
	public String getYomigana() {return yomigana;}
	public void setYomigana(String yomigana) {this.yomigana = yomigana;}
	public String getMeaning() {return meaning;}
	public void setMeaning(String meaning) {this.meaning = meaning;}
	public String getLinkAddress() {return linkAddress;}
	public void setLinkAddress(String linkAddress) {this.linkAddress = linkAddress;}
	public String getWordLevel() {return wordLevel;}
	public void setWordLevel(String wordLevel) {this.wordLevel = wordLevel;}
	
	public Word() {	}
	
	public Word(int wordNum, String word, String yomigana, String meaning, String linkAddress, String wordLevel) {
		super();
		this.wordNum = wordNum;
		this.word = word;
		this.yomigana = yomigana;
		this.meaning = meaning;
		this.linkAddress = linkAddress;
		this.wordLevel = wordLevel;
	}
	@Override
	public String toString() {
		return "Word [wordNum=" + wordNum + ", word=" + word + ", yomigana=" + yomigana + ", meaning=" + meaning
				+ ", linkAddress=" + linkAddress + ", wordLevel=" + wordLevel + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linkAddress == null) ? 0 : linkAddress.hashCode());
		result = prime * result + ((meaning == null) ? 0 : meaning.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		result = prime * result + ((wordLevel == null) ? 0 : wordLevel.hashCode());
		result = prime * result + wordNum;
		result = prime * result + ((yomigana == null) ? 0 : yomigana.hashCode());
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
		Word other = (Word) obj;
		if (linkAddress == null) {
			if (other.linkAddress != null)
				return false;
		} else if (!linkAddress.equals(other.linkAddress))
			return false;
		if (meaning == null) {
			if (other.meaning != null)
				return false;
		} else if (!meaning.equals(other.meaning))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		if (wordLevel == null) {
			if (other.wordLevel != null)
				return false;
		} else if (!wordLevel.equals(other.wordLevel))
			return false;
		if (wordNum != other.wordNum)
			return false;
		if (yomigana == null) {
			if (other.yomigana != null)
				return false;
		} else if (!yomigana.equals(other.yomigana))
			return false;
		return true;
	}
	
	
}
