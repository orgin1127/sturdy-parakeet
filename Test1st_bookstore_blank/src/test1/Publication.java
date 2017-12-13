package test1;

import java.io.Serializable;

/**
 * 서점 관리 프로그램의 상품정보(Book, Magazine, Ebook) 클래스의 슈퍼 클래스
 * 상품들의 공통 속성인 제목, 출판사, 가격을 멤버 변수로 갖는다.
 * */
public class Publication implements Serializable {
	private int productId;		// 제품번호
	private String title;		// 제목
	private String company;		// 출판사
	private int price;			// 가격
	
	/**
	 * 기본 생성자
	 */
	public Publication() {}

	/**
	 * 전달된 제목, 출판사, 가격 정보를 가지고 Publication 객체를 생성한다.
	 * @param title 제목
	 * @param company 출판사
	 * @param price	가격
	 */
	public Publication(int productId, String title, String company, int price) {
		this.productId = productId;
		this.title = title;
		this.company = company;
		this.price = price;
	}
	
	/**
	 * 제품번호를 조회한다 
	 * @return 객체가 가지고 있는 제품번호
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * 새로운 제품번호로 변경한다
	 * @param productId 변경하고자 하는 제품번호
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * 제목을 조회한다.
	 * @return 객체가 가지고 있는 제목
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 새로운 제목으로 변경한다.
	 * @param title 변경하고자 하는 제목
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 출판사를 조회한다.
	 * @return 객체가 가지고 있는 출판사명
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * 새로운 출판사명으로 변경한다.
	 * @param company 변경하고자 하는 출판사명
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * 가격을 조회한다.
	 * @return 객체가 가지고 있는 가격
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 새로운 가격으로 변경한다.
	 * @param price 변경하고자 하는 가격
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 객체가 가지고 있는 제목, 출판사, 가격 정보를 문자열로 리턴한다.
	 * @return 객체의 내용
	 */
	@Override
	public String toString() {
		return "제품번호:" + productId + ", 제목:" + title + ", 출판사:" + company + ", 가격:" + price;
	}
}
