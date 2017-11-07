package SES;

public class Trainee extends Human {
	
	private String stdNo;

	public String getStdNo() {return stdNo;}
	public void setStdNo(String stdNo) {this.stdNo = stdNo;}
	
	public Trainee() {}
	
	public Trainee(String name, int age, String jumin, String stdNo) {
		super(name, age, jumin);
		this.stdNo = stdNo;
	}
	
	@Override
	public String toString() {
		return super.toString()+", ÇÐ¹ø: "+stdNo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Trainee))
			return false;
		Trainee other = (Trainee) obj;
		if (stdNo == null) {
			if (other.stdNo != null)
				return false;
		} else if (!stdNo.equals(other.stdNo))
			return false;
		return true;
	}
	
}
