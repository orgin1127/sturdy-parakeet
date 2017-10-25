package Step3;
import java.io.*;
import java.util.*;

/**
 * <pre>
 * SES(Soft Engineer School) 관리 프로그램의 업무로직을 관리하는 클래스
 * 주요 기능으로는 다음과 같다.
 * 1. 신규 관리인원 등록
 * 2. 등록인원 검색
 * 3. 등록인원 삭제
 * 4. 전체 등록인원 출력
 * </pre>
 * */
public class SESManager {
	private final String FILE_NAME = "human.dat";	// 파일명 상수
	private ArrayList<Human> list;	// Human을 담을 리스트
	
	private FileInputStream fis;	//파일을 읽기위한
	private FileOutputStream fos;	//파일을 쓰기위한
	private ObjectInputStream ois;	//객체를 읽기위한
	private ObjectOutputStream oos;	//객체를 쓰기위한
	
	/**
	 * 생성자
	 */
	public SESManager(){
		// 파일을 읽어들인다
		if(new File(FILE_NAME).exists()){
			getFile();
		} else {
			list = new ArrayList<Human>();
		}
	}
	
	/**
	 * 새로운 Human 객체를 등록한다.
	 * @param human 등록할 Professor, Trainee, Staff 클래스의 객체
	 * @return 성공 여부
	 * */
	public boolean insertHuman(Human human) {
		Human find_h = findHuman(human.getJumin());
		
		// 등록된 주민번호인지 체크한다
		if (find_h != null) {
			return false;
		}
		
		// 파일에 저장 리스트를 덮어쓴다
		list.add(human);
		
		if (setFile() == false) {
			// 만약 실패한다면 방금 등록한 human을 리스트에서 삭제
			list.remove(human);
			return false;
		}
		
		return true;
	}

	/**
	 * 등록된 Human 객체를 검색한다.
	 * @param jumin 검색할 Human의 주민번호
	 * @return Human 배열에 등록된 객체들 중 파라메터로 전달된 주민번호와 일치되는 Human 객체, 검색 결과가 없을 시 null을 반환한다.
	 * */
	public Human findHuman(String jumin) {
		for(Human h : list){
			if(h.getJumin().equals(jumin)) {
				return h;
			}
		}
		
		return null;
	}

	/**
	 * 등록된 Human 객체를 삭제한다.
	 * @param jumin 삭제할 Human의 주민번호
	 * @return 주어진 주민번호와 일치되는 Human 객체의 삭제 결과, Human 배열에 등록된 객체들 중 파라메터로 전달된 주민번호와 일치되는 Human 객체가 발견되어 삭제를 성공하면 true를 그렇지 않으면 false를 반환
	 * */
	public boolean deleteHuman(String jumin){
		for(Human h : list){
			if(h.getJumin().equals(jumin)){
				list.remove(h);
				setFile();
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 등록된 모든 Human 객체 정보를 출력한다.
	 * */
	public void showAll() {
		Iterator<Human> it = list.iterator();
		
		while(it.hasNext()){
			it.next().showInfo();
		}
	}
	
	/**
	 * 등록된 모든 Human 객체 정보를 파일에 쓴다.
	 * @return 파일 쓰기 성공 여부
	 * */
	public boolean setFile(){
		boolean result = false;
		try{
			fos = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			result = true;
		} catch(Exception e){
			// e.printStackTrace();
			System.out.println("[에러] 파일 쓰기에 실패했습니다.");
		} finally {
			closeStreams();
		}
		return result;
	}
	
	/**
	 * 파일에 쓰여진 모든 Human 객체 정보를 읽어들인다.
	 * */
	@SuppressWarnings("unchecked")
	public void getFile() {
		try{
			// 파일 스트림으로부터 파일명에 해당하는 파일을 읽어들인다
			fis = new FileInputStream(FILE_NAME);
			
			// 파일 스트림으로부터 오브젝트 스트림 형태로 변경
			ois = new ObjectInputStream(fis);
			
			// 오브젝트 스트림으로부터 오브젝트를 읽어 ArrayList<Human>으로 형변환
			list = (ArrayList<Human>) ois.readObject();
		} catch(Exception e) {
			// e.printStackTrace();
			System.out.println("[에러] 파일 읽기에 실패하였습니다.");
		} finally {
			closeStreams();
		}
	}
	
	/**
	 * 스트림 객체를 close 하여 자원을 반환한다.
	 * */
	private void closeStreams() {
		try {
			if(fis != null) fis.close();
			if(fos != null) fos.close();
			if(ois != null) ois.close();
			if(oos != null) oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
