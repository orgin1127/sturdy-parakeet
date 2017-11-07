package SES;

public class Professor extends Human{
	
	private String major;

	public String getMajor() {return major;}
	public void setMajor(String major) {this.major = major;}
	
	public Professor() {}
	
	public Professor(String name, int age, String jumin, String major) {
		super(name, age, jumin);
		this.major = major;
	}
	
	@Override
	public String toString() {
		return super.toString()+", Àü°ø: "+major;
	}

	@Override
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
