package SMS_Practice;

public class Trainee extends Human {
	
	//default
	private String stdNo;

	//getter, setter
	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	//default
	public Trainee() {}

	//constructor
	public Trainee(String name, int age, String jumin, String stdNo) {
		super(name, age, jumin);
		this.stdNo = stdNo;
	}

	@Override //from Human Classes' toString() method
	public String toString() {
		return super.toString() + ", ÇÐ¹ø : " + stdNo;
	}

	@Override //from Human Classes' equals() method
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
