package gov.vo;

import java.io.Serializable;

public class GovernmentOffice implements Serializable {
	
	//field
	private String officeId;
	private String name;
	private String address;
	private int employeeCount;
	
	//default
	public GovernmentOffice() {	}

	//constructor
	public GovernmentOffice(String officeId, String name, String address, int employeeCount) {
		this.officeId = officeId;
		this.name = name;
		this.address = address;
		this.employeeCount = employeeCount;
	}
	
	//getter, setter
	public String getOfficeId() {return officeId;}
	public void setOfficeId(String officeId) {this.officeId = officeId;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public int getEmployeeCount() {return employeeCount;}
	public void setEmployeeCount(int employeeCount) {this.employeeCount = employeeCount;}
	
	
	@Override //from Object Classes' toString() method
	public String toString() {
		return "관리번호: " + this.officeId + ", 관공서 명: " + this.name + 
				", 주소: " + this.address + ", 직원수: " + this.employeeCount;
	}

	@Override //from Object Classes' equals() method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GovernmentOffice))
			return false;
		GovernmentOffice other = (GovernmentOffice) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (employeeCount != other.employeeCount)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (officeId == null) {
			if (other.officeId != null)
				return false;
		} else if (!officeId.equals(other.officeId))
			return false;
		return true;
	}
	
}
