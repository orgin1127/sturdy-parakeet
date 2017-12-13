package test.jsp6.vo;

public class BoardVO {
	
	private int boardNum;
	private String id;
	private String title;
	private String content;
	private String inputdate;
	private int hits;
	private String ip;
	
	public int getBoardNum() {return boardNum;}
	public void setBoardNum(int boardNum) {this.boardNum = boardNum;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public String getInputdate() {return inputdate;}
	public void setInputdate(String inputdate) {this.inputdate = inputdate;}
	public int getHits() {return hits;}
	public void setHits(int hits) {this.hits = hits;}
	public String getIp() {return ip;}
	public void setIp(String ip) {this.ip = ip;}
	
	public BoardVO() {}
	
	public BoardVO(String id, String title, String content, String ip) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.ip = ip;
	}
	
	public BoardVO(int boardNum, String id, String title, String content, String inputdate, int hits, String ip) {
		super();
		this.boardNum = boardNum;
		this.id = id;
		this.title = title;
		this.content = content;
		this.inputdate = inputdate;
		this.hits = hits;
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", inputdate=" + inputdate + ", hits=" + hits + ", ip=" + ip + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNum;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + hits;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inputdate == null) ? 0 : inputdate.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
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
		BoardVO other = (BoardVO) obj;
		if (boardNum != other.boardNum)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (hits != other.hits)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	

	
}
