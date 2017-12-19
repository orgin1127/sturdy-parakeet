package test;

public class Student {
	
	//field
	private String name; //이름
	private int ban; //반
	private int no; //번호
	private int kor; //국어점수
	private int eng; //영어점수
	private int math; //수학점수
	
	//getter, setter
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getBan() {return ban;}
	public void setBan(int ban) {this.ban = ban;}
	public int getNo() {return no;}
	public void setNo(int no) {this.no = no;}
	public int getKor() {return kor;}
	public void setKor(int kor) {this.kor = kor;}
	public int getEng() {return eng;}
	public void setEng(int eng) {this.eng = eng;}
	public int getMath() {return math;}
	public void setMath(int math) {this.math = math;}
	
	
	
	//Defalut constructor
	public Student() {}
	
	//Constructor
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getTotal() {
		int total = 0;
		
		total = getKor()+getEng()+getMath();
		
		return total;
	}
	
	public double getAverage() {
		double ave = 0;
		ave = getTotal()/3.0;
		return ave;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", ban=" + ban + ", no=" + no + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ban;
		result = prime * result + eng;
		result = prime * result + kor;
		result = prime * result + math;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
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
		Student other = (Student) obj;
		if (ban != other.ban)
			return false;
		if (eng != other.eng)
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		return true;
	}
	
	
	

}
