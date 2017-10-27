package gov.vo;

public class PoliceOffice extends GovernmentOffice {
	
	//field
	private String district;
	
	//default
	public PoliceOffice() {	}
	
	//constructor
	public PoliceOffice(String officeId, String name, String address, int employeeCount,
			String district) {
		super(officeId, name, address, employeeCount);
		this.district = district;
	}
	
	//getter, setter
	public String getDistrict() {return district;}
	public void setDistrict(String district) {this.district = district;}

	@Override //from GovermentOffice Classes' toString()
	public String toString() {
		return super.toString() + ", 관할 구역: " + this.district;
	}

	@Override //from GovermentOffice Classes' equals()
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof PoliceOffice))
			return false;
		PoliceOffice other = (PoliceOffice) obj;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		return true;
	}
	
}
