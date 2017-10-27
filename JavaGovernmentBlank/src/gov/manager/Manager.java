package gov.manager;

import java.io.*;
import java.util.ArrayList;

import gov.vo.FireStation;
import gov.vo.GovernmentOffice;
import gov.vo.PoliceOffice;

public class Manager {
	
	private final String FILE_NAME = "gov.dat";
	
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private ArrayList<GovernmentOffice> officeList;	// 관공서 리스트
	
	/**
	 * Constructor
	 */
	public Manager() {
		if(new File(FILE_NAME).exists()){
			loadFile();
		} else {
			officeList = new ArrayList<GovernmentOffice>();
		}
	}
	
	/**
	 * gov.dat를 저장한다
	 */
	public boolean saveFile() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			oos.writeObject(officeList);
			return true;
		}
		catch (IOException e) {
			System.out.println("[에러] 파일 저장 실패");
			e.printStackTrace();
			return false;
		}
		finally {
			closeAllStream();
		}
	}
	
	/**
	 * gov.dat를 불러온다
	 */
	@SuppressWarnings("unchecked")
	public void loadFile() {
		try {
			ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
			officeList = (ArrayList<GovernmentOffice>) ois.readObject();
		}
		catch (Exception e) {
			System.out.println("파일 불러오기 실패");
			e.printStackTrace();
		}
		finally {
			closeAllStream();
		}
	}
	
	/**
	 * 관공서 정보를 저장한다. 관공서는 관리 번호에 의해 분류되고 중복될 수 없다.
	 * @param office 저장할 관공서 정보
	 * @return 저장 여부
	 */
	public boolean insert(GovernmentOffice office) {
		if (search(office.getOfficeId()) == null) {
			officeList.add(office);
			if (saveFile()) {
				return true;
			}
		}
			return false;
	}

	/**
	 * 관리 번호를 통해 관공서 정보를 찾는다.
	 * @param officeId 검색할 관공서의 관리 번호
	 * @return 일치하는 관공서 정보
	 */
	public GovernmentOffice search(String officeId) {
		for (GovernmentOffice findG : officeList) {
			if (findG.getOfficeId().equals(officeId)) {
				return findG;
			}
		}
		return null;
	}

	/**
	 * 관리 번호를 통해 관공서 정보를 삭제한다.
	 * @param officeId 삭제할 관공서의 관리 번호
	 * @return 삭제 여부
	 */
	public boolean delete(String officeId) {
		GovernmentOffice deleteG = search(officeId);
		if (deleteG != null) {
			officeList.remove(deleteG);
			saveFile();
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 관공서 리스트를 얻는다
	 * @return
	 */
	public ArrayList<GovernmentOffice> getOfficeList() {
		return officeList;
	}

	/**
	 * 경찰서의 종사자 숫자를 얻는다
	 * @return 경찰서의 종사자 수
	 */
	public int getPoliceOfficeCount() {
		int count = 0;
		for (GovernmentOffice policeOfficeNum : officeList) {
			if (policeOfficeNum instanceof PoliceOffice) {
				count = count + policeOfficeNum.getEmployeeCount();
			}
		}
		return count;
	}

	/**
	 * 소방서의 종사자 숫자를 얻는다
	 * @return 소방서의 종사자 수
	 */
	public int getFireStationCount() {
		int count = 0;
		for (GovernmentOffice fireStationNum : officeList) {
			if (fireStationNum instanceof FireStation) {
				count = count + fireStationNum.getEmployeeCount();
			}
		}
		return count;
	}

	/**
	 * 전체 관공서의 종사자 수를 얻는다
	 * @return 전체 관공서의 종사자 수
	 */
	public int getEmployeeCount() {
		int sum = 0;
		for (GovernmentOffice governmentOffice : officeList) {
			sum = sum + governmentOffice.getEmployeeCount();
		}
		return sum;
	}
	
	public void closeAllStream() {
		try {
			if (fis != null) fis.close();
			if (fos != null) fos.close();
			if (oos != null) oos.close();
			if (ois != null) ois.close();
		}
		catch (IOException e) {
			System.out.println("[에러] 입출력 스트림 종료 실패");
			e.printStackTrace();
		}
	}
}
