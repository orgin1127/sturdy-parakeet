package AnimalStep2;

public class Population extends VO{
	
	//field
	private int population;

	//getter, setter
	public int getPopulation() {return population;}
	public void setPopulation(int population) {this.population = population;}
	
	//default
	public Population() {}
	
	//constructor
	public Population(String name, String specise, int weight, int age, String food, int population) {
		super(name, specise, weight, age, food);
		this.population = population;
	}
	
	@Override //from VO Classes' toString() method
	public String toString() {
		super.toString();
		return ", 개체수: "+population+"마리";
	}

	@Override //from VO Classes' equals() method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Population))
			return false;
		Population other = (Population) obj;
		if (population != other.population)
			return false;
		return true;
	}
}
