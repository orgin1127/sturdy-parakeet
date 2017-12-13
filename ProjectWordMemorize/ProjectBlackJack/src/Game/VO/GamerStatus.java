package Game.VO;

public class GamerStatus {
	
	private String id;
	private int money;
	private int win_count;
	private int lose_count;
	
	public GamerStatus() {}
	
	public GamerStatus(String id, int money, int win_count, int lose_count) {
		this.id = id;
		this.money = money;
		this.win_count = win_count;
		this.lose_count = lose_count;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getWin_count() {
		return win_count;
	}
	public void setWin_count(int win_count) {
		this.win_count = win_count;
	}
	public int getLose_count() {
		return lose_count;
	}
	public void setLose_count(int lose_count) {
		this.lose_count = lose_count;
	}

	@Override
	public String toString() {
		String s = "ID : "+id+", 보유금액 : "+money+"원"+
				", 승리 : "+win_count+", 패배 : "+lose_count;
		return s;
	}
	
	
	
	
	
	
}
