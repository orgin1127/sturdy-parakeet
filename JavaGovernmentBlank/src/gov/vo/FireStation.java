package gov.vo;

public class FireStation extends GovernmentOffice {
	
	//field
	private int firetruckCount;
	
	//default
	public FireStation() {	}

	//constructor
	public FireStation(String officeId, String name, String address, int employeeCount,
			int firetruckCount) {
		super(officeId, name, address, employeeCount);
		this.firetruckCount = firetruckCount;
	}

	//getter, setter
	public int getFiretruckCount() {return firetruckCount;}
	public void setFiretruckCount(int firetruckCount) {this.firetruckCount = firetruckCount;}

	
	@Override //from GovermentOffice Classes' toString()
	public String toString() {
		return super.toString() + ", 소방차 수: " + this.firetruckCount;
	}

	@Override //from GovermentOffice Classes' equals()
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof FireStation))
			return false;
		FireStation other = (FireStation) obj;
		if (firetruckCount != other.firetruckCount)
			return false;
		return true;
	}

}
