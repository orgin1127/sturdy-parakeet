package BJVO;

public class BJVO {
	
	private String pattern;
	private String number;
	
	public String getPattern() {return pattern;	}
	public void setPattern(String pattern) {this.pattern = pattern;}
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number = number;}
	
	public BJVO() {}
	
	public BJVO(String pattern, String number) {
		this.pattern = pattern;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return pattern + number;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BJVO other = (BJVO) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.equals(other.pattern))
			return false;
		return true;
	}

}
