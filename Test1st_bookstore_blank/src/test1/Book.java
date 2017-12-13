package test1;

/**
 * 서점 관리 프로그램의 상품정보 중 책에 대한 정보를 관리하는 클래스
 * Publication 클래스를 상속하고 있으며, 책의 추가 정보인 저자명을 멤버변수로 갖는다.
 */
public class Book extends Publication {
	private String author;		//저자

	/**
	 * 기본 생성자
	 */
	public Book() {
	}

	/**
	 * 전달된 제목, 출판사, 가격, 저자 정보를 가지고 Book 객체를 생성한다.
	 * @param title 제목
	 * @param company 출판사
	 * @param price	가격
	 * @param author 저자
	 */
	public Book(int productId, String title, String company, int price, String author) {
		super(productId, title, company, price);
		this.author = author;
	}

	/**
	 * 저자를 조회한다.
	 * @return 객체가 가지고 있는 저자명
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 새로운 저자로 변경한다.
	 * @param author 변경하고자 하는 새로운 저자명
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 객체가 가지고 있는 제목, 출판사, 가격, 저자 정보를 문자열로 리턴한다.
	 * @return 객체의 내용
	 */
	@Override
	public String toString() {
		return super.toString() + ", 저자:" + author;
	}
}
