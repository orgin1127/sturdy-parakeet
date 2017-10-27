package toy.vo;

public class Bicycle extends Toy {
	private String type;	// 자전거 종류
	
	/*
	 * Constructors
	 */
	public Bicycle(){}
	
	public Bicycle(String code, String name, int price, String type) {
		super(code, name, price);
		this.type = type;
	}

	/*
	 * Getters and setters
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "[자전거]\t" +  super.toString() + ",\t종류 = " + type + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Bicycle))
			return false;
		Bicycle other = (Bicycle) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
}
