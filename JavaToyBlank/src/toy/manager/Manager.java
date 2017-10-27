package toy.manager;

import java.io.*;
import java.util.ArrayList;

import toy.vo.Bicycle;
import toy.vo.Drone;
import toy.vo.GameConsole;
import toy.vo.Toy;

/**
 * 장난감 정보를 관리하는 클래스
 */
public class Manager {
	private final String FILE_NAME = "toyList.dat";
	
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private ArrayList<Toy> toyList;		// 장난감 리스트

	
	/**
	 * Constructor
	 */
	public Manager() {
		if(new File(FILE_NAME).exists()){
			loadFile();
		} else {
			toyList = new ArrayList<Toy>();
		}
	}
	
	/**
	 * toyList.dat를 저장한다
	 */
	public void saveFile() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			oos.writeObject(toyList);
		}
		
		catch(IOException e) {
			System.out.println("[에러] 파일 저장 실패");
		}
		finally {
			closeAllStream();
		}
	}
	
	/**
	 * toyList.dat를 불러온다
	 */
	@SuppressWarnings("unchecked")
	public void loadFile() {
		try {
			ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
			toyList = (ArrayList<Toy>) ois.readObject();
		}
		catch (Exception e) {
			System.out.println("[에러] 파일 로드 실패");
		}
		finally {
			closeAllStream();
		}
	}
	
	/**
	 * 장난감을 저장한다. 장난감은 code에 의해 분류되고 같은 code는 사용할 수 없다.
	 * @param toy 저장할 장난감 정보
	 * @return 저장 여부
	 */
	public boolean insert(Toy toy) {
		if (search(toy.getCode()) == null) {
			toyList.add(toy);
			saveFile();
			return true;
		}
		return false;
	}
	
	/**
	 * code를 통해 장난감을 찾는다. 코드가 일치하는 장난감을 찾으면 그것을 반환한다.
	 * @param code 검색할 장난감 코드
	 * @return 일치하는 장난감 정보
	 */
	public Toy search(String code) {
		for (Toy toy : toyList) {
			if (toy.getCode().equals(code)) {
				return toy;
			}
		}
		return null;
	}

	/**
	 * code를 통해 장난감을 삭제한다. 코드가 일치하는 장난감을 찾으면 삭제한다. 
	 * @param code 삭제할 장난감 코드
	 * @return 삭제 여부
	 */
	public boolean delete(String code) {
		Toy deletT = search(code);
		if (deletT != null) {
			toyList.remove(deletT);
			saveFile();
			return true;
		}
		return false;
	}

	/**
	 * 장난감 리스트를 얻는다
	 * @return 장난감 리스트
	 */
	public ArrayList<Toy> getToyList() {
		return toyList;
	}
	
	public void closeAllStream() {
		try {
			if (fis != null ) fis.close();
			if (fos != null ) fos.close();
			if (ois != null ) ois.close();
			if (oos != null ) oos.close();
		}
		catch (IOException e) {
			System.out.println("입출력 스트림 종료 실패");
		}
	}
	
}
