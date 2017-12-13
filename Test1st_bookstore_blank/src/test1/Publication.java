package test1;

import java.io.Serializable;

/**
 * ���� ���� ���α׷��� ��ǰ����(Book, Magazine, Ebook) Ŭ������ ���� Ŭ����
 * ��ǰ���� ���� �Ӽ��� ����, ���ǻ�, ������ ��� ������ ���´�.
 * */
public class Publication implements Serializable {
	private int productId;		// ��ǰ��ȣ
	private String title;		// ����
	private String company;		// ���ǻ�
	private int price;			// ����
	
	/**
	 * �⺻ ������
	 */
	public Publication() {}

	/**
	 * ���޵� ����, ���ǻ�, ���� ������ ������ Publication ��ü�� �����Ѵ�.
	 * @param title ����
	 * @param company ���ǻ�
	 * @param price	����
	 */
	public Publication(int productId, String title, String company, int price) {
		this.productId = productId;
		this.title = title;
		this.company = company;
		this.price = price;
	}
	
	/**
	 * ��ǰ��ȣ�� ��ȸ�Ѵ� 
	 * @return ��ü�� ������ �ִ� ��ǰ��ȣ
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * ���ο� ��ǰ��ȣ�� �����Ѵ�
	 * @param productId �����ϰ��� �ϴ� ��ǰ��ȣ
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * ������ ��ȸ�Ѵ�.
	 * @return ��ü�� ������ �ִ� ����
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * ���ο� �������� �����Ѵ�.
	 * @param title �����ϰ��� �ϴ� ����
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * ���ǻ縦 ��ȸ�Ѵ�.
	 * @return ��ü�� ������ �ִ� ���ǻ��
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * ���ο� ���ǻ������ �����Ѵ�.
	 * @param company �����ϰ��� �ϴ� ���ǻ��
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * ������ ��ȸ�Ѵ�.
	 * @return ��ü�� ������ �ִ� ����
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * ���ο� �������� �����Ѵ�.
	 * @param price �����ϰ��� �ϴ� ����
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * ��ü�� ������ �ִ� ����, ���ǻ�, ���� ������ ���ڿ��� �����Ѵ�.
	 * @return ��ü�� ����
	 */
	@Override
	public String toString() {
		return "��ǰ��ȣ:" + productId + ", ����:" + title + ", ���ǻ�:" + company + ", ����:" + price;
	}
}
