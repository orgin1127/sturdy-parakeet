package Game.VO;

public class Gamer {
	
	private String id;
	private String password;
	
	public Gamer() {}
	
	public Gamer(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "���̵� : "+id+", ��й�ȣ : "+password;
	}
	
	
	
	
	
	
	
}
