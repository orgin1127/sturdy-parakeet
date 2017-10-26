package SMS_Practice;

public class Staff extends Human{
	
	//field
	private String department;

	//getter, setter
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	//default
	public Staff() {}
	
	//constructor
	public Staff(String name, int age, String jumin, String department) {
		super(name, age, jumin);
		this.department = department;
	}

	@Override //from Human Classes' toString() method
	public String toString() {
		return super.toString() + ", ºÎ¼­ : " + department;
	}

	@Override //from Human Classes' equals() method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Staff))
			return false;
		Staff other = (Staff) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		return true;
	}
	
	

}
