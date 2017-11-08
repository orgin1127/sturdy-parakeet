package test1;

/**
 * ���� ���� ���α׷��� ��ǰ���� �� ������ ���� ������ �����ϴ� Ŭ����
 * Publication Ŭ������ ����ϰ� ������, ������ �߰� ������ �����,���� ��������� ���´�.
 */
public class Magazine extends Publication {
	private int year;		// ����⵵
	private int month;		// �����

	/**
	 * �⺻ ������
	 */
	public Magazine() {
	}

	/**
	 * ���޵� ����, ���ǻ�, ����, ���� ����� ������ ������ Magazine ��ü�� �����Ѵ�.
	 * @param title ����
	 * @param company ���ǻ�
	 * @param price	����
	 * @param year ����⵵
	 * @param month �����
	 */
	public Magazine(int productId, String title, String company, int price, int year, int month) {
		super(productId, title, company, price);
		this.year = year;
		this.month = month;
	}

	/**
	 * ����⵵�� ��ȸ�Ѵ�.
	 * @return ��ü�� ������ �ִ� ����⵵
	 */
	public int getYear() {
		return year;
	}

	/**
	 * ����⵵�� �����Ѵ�.
	 * @param year �����ϰ��� �ϴ� ���ο� ����⵵
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * ������� ��ȸ�Ѵ�.
	 * @return ��ü�� ������ �ִ� �����
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * ������� �����Ѵ�.
	 * @param month �����ϰ��� �ϴ� ���ο� �����
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * ��ü�� ������ �ִ� ����, ���ǻ�, ����, ����⵵, ����� ������ ���ڿ��� �����Ѵ�.
	 * @return ��ü�� ����
	 */
	@Override
	public String toString() {
		return super.toString() + ", �����/��:" + year + "/" + month;
	}
}
