package AnimalStep2;

import java.io.Serializable;

public class VO implements Serializable {
	
	//field
	private String name;
	private String specise;
	private int weight;
	private int age;
	private String food;
	
	//getter, setter
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getSpecise() {return specise;}
	public void setSpecise(String specise) {this.specise = specise;}
	public int getWeight() {return weight;}
	public void setWeight(int weight) {this.weight = weight;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public String getFood() {return food;}
	public void setFood(String food) {this.food = food;}
	
	//default
	public VO() {}
	
	//constructor
	public VO(String name, String specise, int weight, int age, String food) {
		this.name = name;
		this.specise = specise;
		this.weight = weight;
		this.age = age;
		this.food = food;
	}
	
	@Override //from Object Classes' toString() method
	public String toString() {
		return "이름: " + name + ", 품종: " + specise + ", 무게: " + weight + "kg, 나이: " + age + "세, 주식: " + food;
	}

	@Override //from Object Classes' equals() method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof VO))
			return false;
		VO other = (VO) obj;
		if (age != other.age)
			return false;
		if (food == null) {
			if (other.food != null)
				return false;
		} else if (!food.equals(other.food))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (specise == null) {
			if (other.specise != null)
				return false;
		} else if (!specise.equals(other.specise))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
}
