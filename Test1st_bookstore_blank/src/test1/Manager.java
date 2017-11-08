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
	// 데이터를 저장할 파일 이름
	private final String FILENAME = "pub.dat";
	
	// 서점 관련 정보를 저장하는 리스트
	private ArrayList<Publication> pubList;
	
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;
	private FileInputStream fis = null;
	private ObjectInputStream ois = null;
	/**
	 * 생성자.
	 * 파일이 존재하면 파일로부터 리스트를 읽어들이고
	 * 존재하지 않으면 새롭게 리스트를 작성한다
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
	 * 서점 등록 데이터를 파일에 저장한다
	 */
	private void saveFile() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
			oos.writeObject(pubList);
		}
		catch (Exception e) {
			System.out.println("파일 저장 실패");
		}
		finally {
			closeAllStream();
		}
	}
	
	/**
	 * 서점 등록 데이터를 파일로부터 읽어 들인다
	 */
	private void loadFile() {
		try {
			ois = new ObjectInputStream(new FileInputStream(FILENAME));
			pubList = (ArrayList<Publication>) ois.readObject();
		}
		catch (Exception e) {
			System.out.println("파일 불러오기 실패");
		}
		finally {
			closeAllStream();
		}
	}
	
	/**
	 * 서점 관련 정보를 리스트에 저장한다
	 * @return 저장 완료 시 true
	 */
	public boolean insert(Publication pub) {
		// 제품번호가 중복되면 저장하지 않는다
		boolean insertResult = true;
		for (Publication insertP : pubList) {
			if (insertP.getProductId() == pub.getProductId()) {
				insertResult = false;
				return insertResult;
			}
		}
		pubList.add(pub);
		saveFile();
		//파일에 저장
		//CODE HERE
		
		return insertResult;
	}
	
	/**
	 * 제품번호에 해당하는 서점 정보를 반환한다
	 * @param productId 찾고자 하는 제품의 제품번호
	 * @return 제품번호에 해당하는 서점 정보
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
	 * 제품번호에 해당하는 서점 정보를 삭제한다
	 * @param productId 삭제하고자 하는 제품의 제품번호
	 * @return 삭제 완료 시 true
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
	 * 서점 관리 정보를 가지고 있는 데이터를 반환한다
	 * @return 서점 관리 정보
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
			System.out.println("파일 스트림 종료 실패");
		}
		
	}
}