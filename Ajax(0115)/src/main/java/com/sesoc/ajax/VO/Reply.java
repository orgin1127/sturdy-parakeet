package com.sesoc.ajax.VO;

public class Reply {
	
	private int num;
	private String name;
	private String text;
	
	public int getNum() {return num;}
	public void setNum(int num) {this.num = num;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getText() {return text;}
	public void setText(String text) {this.text = text;}
	
	public Reply() {}
	
	public Reply(int num, String name, String text) {
		this.num = num;
		this.name = name;
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Reply [num=" + num + ", name=" + name + ", text=" + text + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
}
