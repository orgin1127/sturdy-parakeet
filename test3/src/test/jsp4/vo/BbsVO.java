package test.jsp4.vo;

public class BbsVO {
	
	private int num;
	private String name;
	private String text;
	private String indate;
	
	public int getNum() {return num;}
	public void setNum(int num) {this.num = num;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getContent() {return text;}
	public void setContent(String text) {this.text = text;}
	public String getIndate() {return indate;}
	public void setIndate(String indate) {this.indate = indate;}

	public BbsVO() {}
	
	public BbsVO(String name, String text) {
		this.name = name;
		this.text = text;
	}
	
	public BbsVO(int num, String name, String text, String indate) {
		this.num = num;
		this.name = name;
		this.text = text;
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "BbsVO [num=" + num + ", name=" + name + ", content=" + text + ", indate=" + indate + "]";
	}

}
