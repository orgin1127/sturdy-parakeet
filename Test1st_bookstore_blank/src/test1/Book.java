package test1;

/**
 * ���� ���� ���α׷��� ��ǰ���� �� å�� ���� ������ �����ϴ� Ŭ����
 * Publication Ŭ������ ����ϰ� ������, å�� �߰� ������ ���ڸ��� ��������� ���´�.
 */
public class Book extends Publication {
	private String author;		//����

	/**
	 * �⺻ ������
	 */
	public Book() {
	}

	/**
	 * ���޵� ����, ���ǻ�, ����, ���� ������ ������ Book ��ü�� �����Ѵ�.
	 * @param title ����
	 * @param company ���ǻ�
	 * @param price	����
	 * @param author ����
	 */
	public Book(int productId, String title, String company, int price, String author) {
		super(productId, title, company, price);
		this.author = author;
	}

	/**
	 * ���ڸ� ��ȸ�Ѵ�.
	 * @return ��ü�� ������ �ִ� ���ڸ�
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * ���ο� ���ڷ� �����Ѵ�.
	 * @param author �����ϰ��� �ϴ� ���ο� ���ڸ�
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * ��ü�� ������ �ִ� ����, ���ǻ�, ����, ���� ������ ���ڿ��� �����Ѵ�.
	 * @return ��ü�� ����
	 */
	@Override
	public String toString() {
		return super.toString() + ", ����:" + author;
	}
}
