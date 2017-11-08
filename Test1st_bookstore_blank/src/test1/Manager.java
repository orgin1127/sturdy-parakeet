package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Manager {
	// �����͸� ������ ���� �̸�
	private final String FILENAME = "pub.dat";
	
	// ���� ���� ������ �����ϴ� ����Ʈ
	private ArrayList<Publication> pubList;
	
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;
	private FileInputStream fis = null;
	private ObjectInputStream ois = null;
	/**
	 * ������.
	 * ������ �����ϸ� ���Ϸκ��� ����Ʈ�� �о���̰�
	 * �������� ������ ���Ӱ� ����Ʈ�� �ۼ��Ѵ�
	 */
	public Manager() {
		//CODE HERE
		if (new File(FILENAME).exists()) {
			loadFile();
		}
		else {
			pubList = new ArrayList<>();
		}
	}
	
	/**
	 * ���� ��� �����͸� ���Ͽ� �����Ѵ�
	 */
	private void saveFile() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
			oos.writeObject(pubList);
		}
		catch (Exception e) {
			System.out.println("���� ���� ����");
		}
		finally {
			closeAllStream();
		}
	}
	
	/**
	 * ���� ��� �����͸� ���Ϸκ��� �о� ���δ�
	 */
	private void loadFile() {
		try {
			ois = new ObjectInputStream(new FileInputStream(FILENAME));
			pubList = (ArrayList<Publication>) ois.readObject();
		}
		catch (Exception e) {
			System.out.println("���� �ҷ����� ����");
		}
		finally {
			closeAllStream();
		}
	}
	
	/**
	 * ���� ���� ������ ����Ʈ�� �����Ѵ�
	 * @return ���� �Ϸ� �� true
	 */
	public boolean insert(Publication pub) {
		// ��ǰ��ȣ�� �ߺ��Ǹ� �������� �ʴ´�
		boolean insertResult = true;
		for (Publication insertP : pubList) {
			if (insertP.getProductId() == pub.getProductId()) {
				insertResult = false;
				return insertResult;
			}
		}
		pubList.add(pub);
		saveFile();
		//���Ͽ� ����
		//CODE HERE
		
		return insertResult;
	}
	
	/**
	 * ��ǰ��ȣ�� �ش��ϴ� ���� ������ ��ȯ�Ѵ�
	 * @param productId ã���� �ϴ� ��ǰ�� ��ǰ��ȣ
	 * @return ��ǰ��ȣ�� �ش��ϴ� ���� ����
	 */
	public Publication select(int productId) {
		for (Publication findProduct : pubList) {
			if (findProduct.getProductId()==productId) {
				return findProduct;
			}
		}
		return null;
	}
	
	/**
	 * ��ǰ��ȣ�� �ش��ϴ� ���� ������ �����Ѵ�
	 * @param productId �����ϰ��� �ϴ� ��ǰ�� ��ǰ��ȣ
	 * @return ���� �Ϸ� �� true
	 */
	public boolean delete(int productId) {
		Publication deleteP = select(productId);
		if (deleteP != null) {
			pubList.remove(deleteP);
			saveFile();
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ���� ���� ������ ������ �ִ� �����͸� ��ȯ�Ѵ�
	 * @return ���� ���� ����
	 */
	public ArrayList<Publication> getPubList() {
		//CODE HERE
		if (pubList.isEmpty()) {
			return null;
		}
		else {
			return pubList;
		}
	}
	
	public void closeAllStream() {
		try {
			if (fis != null) fis.close();
			if (fos != null) fos.close();
			if (ois != null) ois.close();
			if (oos != null) oos.close();
		}
		catch (Exception e) {
			System.out.println("���� ��Ʈ�� ���� ����");
		}
		
	}
}