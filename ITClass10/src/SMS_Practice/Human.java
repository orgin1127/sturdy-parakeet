package SMS_Practice;

import java.io.Serializable;

public class Human implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 411344988749296379L;
	//field
	private String name;
	private int age;
	private String jumin;
	
	//getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	
	//default
	public Human() {}

	//constructor
	public Human(String name, int age, String jumin) {
		super();
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}
	
	@Override //from Object classes' toString() method
	public String toString() {
		return "이름 : " + name + ", 나이 : " + age + ", 주민번호 : " + jumin;
	}

	@Override //from Object classes' equals() method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Human))
			return false;
		Human other = (Human) obj;
		if (age != other.age)
			return false;
		if (jumin == null) {
			if (other.jumin != null)
				return false;
		} else if (!jumin.equals(other.jumin))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
