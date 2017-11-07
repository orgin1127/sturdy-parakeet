package SES;

public class Staff extends Human{
	
	private String field;

	public String getField() {return field;}
	public void setField(String field) {this.field = field;}
	
	public Staff() {}
	
	public Staff(String name, int age, String jumin, String field) {
		super(name, age, jumin);
		this.field = field;
	}
	
	@Override
	public String toString() {
		return super.toString()+", ºÎ¼­: "+field;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Staff))
			return false;
		Staff other = (Staff) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		return true;
	}

}
