package toy.vo;

public class Drone extends Toy {
	private int wingCount;	// 날개의 갯수
	
	/*
	 * Constructors
	 */
	public Drone() {}
	
	public Drone(String code, String name, int price, int wingCount) {
		super(code, name, price);
		this.wingCount = wingCount;
	}

	/*
	 * Getters and setters
	 */
	public int getWingCount() {
		return wingCount;
	}

	public void setWingCount(int wingCount) {
		this.wingCount = wingCount;
	}

	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "[드론]\t" +  super.toString() + ",\t날개 수 = " + wingCount + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Drone))
			return false;
		Drone other = (Drone) obj;
		if (wingCount != other.wingCount)
			return false;
		return true;
	}

	
}
