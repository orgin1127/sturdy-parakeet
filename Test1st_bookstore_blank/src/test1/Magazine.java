package test1;

/**
 * 서점 관리 프로그램의 상품정보 중 잡지에 대한 정보를 관리하는 클래스
 * Publication 클래스를 상속하고 있으며, 잡지의 추가 정보인 발행년,월을 멤버변수로 갖는다.
 */
public class Magazine extends Publication {
	private int year;		// 발행년도
	private int month;		// 발행월

	/**
	 * 기본 생성자
	 */
	public Magazine() {
	}

	/**
	 * 전달된 제목, 출판사, 가격, 발행 년월을 정보를 가지고 Magazine 객체를 생성한다.
	 * @param title 제목
	 * @param company 출판사
	 * @param price	가격
	 * @param year 발행년도
	 * @param month 발행월
	 */
	public Magazine(int productId, String title, String company, int price, int year, int month) {
		super(productId, title, company, price);
		this.year = year;
		this.month = month;
	}

	/**
	 * 발행년도를 조회한다.
	 * @return 객체가 가지고 있는 발행년도
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 발행년도를 변경한다.
	 * @param year 변경하고자 하는 새로운 발행년도
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * 발행월을 조회한다.
	 * @return 객체가 가지고 있는 발행월
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * 발행월을 변경한다.
	 * @param month 변경하고자 하는 새로운 발행월
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * 객체가 가지고 있는 제목, 출판사, 가격, 발행년도, 발행월 정보를 문자열로 리턴한다.
	 * @return 객체의 내용
	 */
	@Override
	public String toString() {
		return super.toString() + ", 발행년/월:" + year + "/" + month;
	}
}
