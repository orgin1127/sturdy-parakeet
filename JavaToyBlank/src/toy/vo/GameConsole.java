package toy.vo;

public class GameConsole extends Toy {
	private String company;
	
	public GameConsole(String code, String name, int price, String company) {
		super(code, name, price);
		this.company = company;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "[게임콘솔]" +  super.toString() + ",\t제조사 = " + company + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof GameConsole))
			return false;
		GameConsole other = (GameConsole) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		return true;
	}
	
	
}
