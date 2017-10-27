package AnimalStep2;

public class Zookeeper extends VO {
	
	//field
	private String zookeeper;

	//getter, setter
	public String getZookeeper() {return zookeeper;}
	public void setZookeeper(String zookeeper) {this.zookeeper = zookeeper;}
	
	//default
	public Zookeeper() {}
	
	//constructor
	public Zookeeper(String name, String specise, int weight, int age, String food, String zookeeper) {
		super(name, specise, weight, age, food);
		this.zookeeper = zookeeper;
	}
	
	@Override //from VO Classes' toString() method
	public String toString() {
		super.toString();
		return ", ªÁ¿∞ªÁ∏Ì: " + zookeeper;
	}

	@Override //from VO Classes' equals() method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Zookeeper))
			return false;
		Zookeeper other = (Zookeeper) obj;
		if (zookeeper == null) {
			if (other.zookeeper != null)
				return false;
		} else if (!zookeeper.equals(other.zookeeper))
			return false;
		return true;
	}

}
