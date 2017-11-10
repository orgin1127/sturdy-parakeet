package board.vo;

public class Board {
	private int boardnum; //�Խñ� ��ȣ
	private String name;
	private String title;
	private String content;
	private int hits;
	private String indate;
	
	public Board() {}

	public Board(int boardnum, String name, String title, String content, int hits, String indate) {
		super();
		this.boardnum = boardnum;
		this.name = name;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.indate = indate;
	}
	
	public Board(String name, String title, String content) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
	}

	public int getBoardnum() {return boardnum;}
	public void setBoardnum(int boardnum) {this.boardnum = boardnum;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public int getHits() {return hits;}
	public void setHits(int hits) {this.hits = hits;}
	public String getIndate() {return indate;}
	public void setIndate(String indate) {this.indate = indate;}

	@Override
	public String toString() {
		return "�� ��ȣ: " + boardnum + ", �̸�: " + name + ", ����: " + title + ", ����: " + content + ", ��ȸ��: "
				+ hits + ", ��¥: " + indate;
	}
	
	public void showBoard() {
		System.out.println("�� ��ȣ: " + boardnum + ", �̸�: " + name + ", ����: " + title + ", ��ȸ��: "
				+ hits + ", ��¥: " + indate);
	}

	public void readBoard() {
		System.out.println("�� ��ȣ: "+this.boardnum);
		System.out.println("�۾���: "+this.name);
		System.out.println("�ۼ���: "+this.indate);
		System.out.println("��ȸ��: "+this.hits);
		System.out.println("����: "+this.title);
		System.out.println("���� : "+this.content );
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
		if (hits != other.hits)
			return false;
		if (indate == null) {
			if (other.indate != null)
				return false;
		} else if (!indate.equals(other.indate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
