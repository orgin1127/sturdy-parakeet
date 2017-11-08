package test1;

/**
 * 서점 관리 프로그램의 상품정보 중 전자책에 대한 정보를 관리하는 클래스
 * Publication 클래스를 상속하고 있으며, 전자책의 추가 정보인 파일형식과 용량을 멤버변수로 갖는다.
 */
public class Ebook extends Publication {
	private String format;		//파일 형식 (PDF/EPUB 등)
	private int filesize;		//파일 용량 (MB 단위)

	/**
	 * 기본 생성자
	 */
	public Ebook() {
	}

	/**
	 * 전달된 제목, 출판사, 가격, 파일형식, 파일크기 정보를 가지고 Ebook 객체를 생성한다.
	 * @param title 제목
	 * @param company 출판사
	 * @param price	가격
	 * @param format 파일형식
	 * @param filesize 파일크기
	 */
	public Ebook(int productId, String title, String company, int price, String format, int filesize) {
		super(productId, title, company, price);
		this.format = format;
		this.filesize = filesize;
	}

	/**
	 * 파일형식을 조회한다.
	 * @return 객체가 가지고 있는 파일형식
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * 파일형식을 변경한다.
	 * @param format 변경하고자 하는 새로운 파일형식
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * 파일크기를 조회한다.
	 * @return 객체가 가지고 있는 파일크기
	 */
	public int getFilesize() {
		return filesize;
	}

	/**
	 * 파일크기를 변경한다.
	 * @param format 변경하고자 하는 새로운 파일크기
	 */
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	/**
	 * 객체가 가지고 있는 제목, 출판사, 가격, 파일형식, 파일크기 정보를 문자열로 리턴한다.
	 * @return 객체의 내용
	 */
	@Override
	public String toString() {
		return super.toString() + ", 파일형식:" + format + ", 파일크기(MB):" + filesize;
	}
}
