package SMS_Practice;

public class Professor extends Human {
	
	//field
	private String major;

	//getter, setter
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	//default
	public Professor() {}

	//constructor
	public Professor(String name, int age, String jumin, String major) {
		super(name, age, jumin);
		this.major = major;
	}

	@Override //from Human Classes' toString() method
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", 전공과목 : " + major;
	}

	@Override //from Human Classes' equals() method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Professor))
			return false;
		Professor other = (Professor) obj;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		return true;
	}
	
}
