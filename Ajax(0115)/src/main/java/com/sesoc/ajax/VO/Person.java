package com.sesoc.ajax.VO;

public class Person {
	
	private String name;
	private String age;
	private String phone;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getAge() {return age;}
	public void setAge(String age) {this.age = age;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	
	public Person() {}
	
	public Person(String name, String age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

}
