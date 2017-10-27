package AnimalStep2;

public class CageArea extends VO {

	//field
	private String cageArea;

	//getter,setter
	public String getCageArea() {return cageArea;}
	public void setCageArea(String cageArea) {this.cageArea = cageArea;}
	
	//default
	public CageArea() {}
	
	//constructor
	public CageArea(String name, String specise, int weight, int age, String food, String cageArea) {
		super(name, specise, weight, age, food);
		this.cageArea = cageArea;
	}
	
	@Override //from VO Classes' toString() method
	public String toString() {
		super.toString();
		return ", 거주구역: "+cageArea;
	}
	
	@Override //from VO Classes' equals() method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof CageArea))
			return false;
		CageArea other = (CageArea) obj;
		if (cageArea == null) {
			if (other.cageArea != null)
				return false;
		} else if (!cageArea.equals(other.cageArea))
			return false;
		return true;
	}
			
}