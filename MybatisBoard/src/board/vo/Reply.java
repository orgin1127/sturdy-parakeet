package board.vo;

public class Reply {
	
	private int replynum;
	private int boardnum;
	private String name;
	private String retext;
	
	public Reply() {}

	public Reply(int replynum, int boardnum, String name, String retext) {
		this.replynum = replynum;
		this.boardnum = boardnum;
		this.name = name;
		this.retext = retext;
	}
	
	public Reply(int boardnum, String name, String retext) {
		this.boardnum = boardnum;
		this.name = name;
		this.retext = retext;
	}

	public int getReplynum() {return replynum;}
	public void setReplynum(int replynum) {this.replynum = replynum;}
	public int getBoardnum() {return boardnum;}
	public void setBoardnum(int boardnum) {this.boardnum = boardnum;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getRetext() {return retext;}
	public void setRetext(String retext) {this.retext = retext;}

	@Override
	public String toString() {
		return "Reply [replynum=" + replynum + ", boardnum=" + boardnum + ", name=" + name + ", retext=" + retext + "]";
	}
	
	public void showReply() {
		System.out.println("리플 작성자: "+name+"		리플 내용: "+retext);
		
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (replynum != other.replynum)
			return false;
		if (retext == null) {
			if (other.retext != null)
				return false;
		} else if (!retext.equals(other.retext))
			return false;
		return true;
	}
	
}
