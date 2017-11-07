package SES;

import java.io.*;
import java.util.ArrayList;

public class SESManager {
	
	private final String FILENAME="SESystem.dat";
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ArrayList<Human> arrList;
	
	public SESManager () {
		if (new File(FILENAME).exists()) {
			getFile();
		}
		else {
			arrList = new ArrayList<>();
		}
	}
	
	public Human findHuman(String jumin) {
		for (Human human : arrList) {
			if (human.getJumin().equals(jumin)) {
				return human;
			}
		}
		return null;
	}
	
	public void getFile() {
		try {
			ois = new ObjectInputStream(new FileInputStream(FILENAME));
			arrList = (ArrayList<Human>) ois.readObject();
		}
		catch (Exception e) {
			System.out.println("���� �б� ����");
		}
		
		finally {
			closeAllStream();
		}
	}
	
	public boolean setFile() {
		try {
		oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
		oos.writeObject(arrList);
		return true;
		}
		catch (Exception e) {
			System.out.println("���� ���� ����");
			return false;
		}
		finally {
			closeAllStream();
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
			System.out.println("��Ʈ�� ���� ����");
		}
	}
}
