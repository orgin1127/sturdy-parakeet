package test1;

/**
 * ���� ���� ���α׷��� ��ǰ���� �� ����å�� ���� ������ �����ϴ� Ŭ����
 * Publication Ŭ������ ����ϰ� ������, ����å�� �߰� ������ �������İ� �뷮�� ��������� ���´�.
 */
public class Ebook extends Publication {
	private String format;		//���� ���� (PDF/EPUB ��)
	private int filesize;		//���� �뷮 (MB ����)

	/**
	 * �⺻ ������
	 */
	public Ebook() {
	}

	/**
	 * ���޵� ����, ���ǻ�, ����, ��������, ����ũ�� ������ ������ Ebook ��ü�� �����Ѵ�.
	 * @param title ����
	 * @param company ���ǻ�
	 * @param price	����
	 * @param format ��������
	 * @param filesize ����ũ��
	 */
	public Ebook(int productId, String title, String company, int price, String format, int filesize) {
		super(productId, title, company, price);
		this.format = format;
		this.filesize = filesize;
	}

	/**
	 * ���������� ��ȸ�Ѵ�.
	 * @return ��ü�� ������ �ִ� ��������
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * ���������� �����Ѵ�.
	 * @param format �����ϰ��� �ϴ� ���ο� ��������
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * ����ũ�⸦ ��ȸ�Ѵ�.
	 * @return ��ü�� ������ �ִ� ����ũ��
	 */
	public int getFilesize() {
		return filesize;
	}

	/**
	 * ����ũ�⸦ �����Ѵ�.
	 * @param format �����ϰ��� �ϴ� ���ο� ����ũ��
	 */
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	/**
	 * ��ü�� ������ �ִ� ����, ���ǻ�, ����, ��������, ����ũ�� ������ ���ڿ��� �����Ѵ�.
	 * @return ��ü�� ����
	 */
	@Override
	public String toString() {
		return super.toString() + ", ��������:" + format + ", ����ũ��(MB):" + filesize;
	}
}
