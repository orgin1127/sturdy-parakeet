package SMS_Practice;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class SMSManager {
	
	Scanner sc = new Scanner(System.in);
	
	private ArrayList<Human> arrList;
	private final String FILENAME = "human.dat";
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	
	public SMSManager () {
		if (new File(FILENAME).exists()) {
			getFile();
		}
		else {
			arrList = new ArrayList<>();
		}
	}
	
	public boolean insertHuman(Human h) {
		Human findH = findHuman(h.getJumin());
		if (findH != null) {
			return false;
		}
		arrList.add(h);
		if (setFile() == false) {
			arrList.remove(h);
			return false;
		}
		return true;
	}
	public boolean deleteHuman(String jumin) {
		Human deleteH = findHuman(jumin);
		if (deleteH == null) {
			System.out.println("없는 주민번호입니다.");
			return false;
		}
		arrList.remove(deleteH);
		if (setFile() == false) {
			return false;
		}
		else {
		System.out.println("삭제성공");
		return true;
		}
	}
	public Human findHuman(String jumin) {
		for (Human h : arrList) {
			if (h.getJumin().equals(jumin)) {
				return h;
			}
		}
		return null;
	}
	
	public void editHuman(String jumin) {
		
		Human editH = findHuman(jumin);
		System.out.print("│이름│ ");
		editH.setName(sc.nextLine());
		System.out.print("│나이│ ");
		editH.setAge(sc.nextInt());
		sc.nextLine();
		String str = "";
			while (true) {
				System.out.print("│주민번호(숫자 13자리만,- 제외)│ ");
				str = sc.nextLine();
				if (Pattern.matches("^[0-9]*$", str) && str.length() == 13) {
					break;
				}
				else {
					System.out.println("0~9 숫자 13자리를 입력하여 주세요");
					continue;
				}
			}
			editH.setJumin(str);
			if (editH instanceof Professor){
				Professor temp = (Professor) editH;
				System.out.print("│전공│ ");
				temp.setMajor(sc.nextLine());
			}
			else if (editH instanceof Trainee){
				Trainee temp = (Trainee) editH;
				System.out.print("│학번│ ");
				temp.setStdNo(sc.nextLine());
			}
			else if (editH instanceof Staff){
				Staff temp = (Staff) editH;
				System.out.print("│부서│ ");
				temp.setDepartment(sc.nextLine());
			}
		
			if (setFile() == false) {
				arrList.remove(editH);
				System.out.println("[에러] 수정실패");
			}
			else {
				System.out.println("수정 성공!");
			}
	}
	
	
	
	public void showAll() {
		Iterator<Human> it = arrList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void getFile() {
		try {
			ois = new ObjectInputStream(new FileInputStream(FILENAME));
			arrList = (ArrayList<Human>) ois.readObject();
		}
		catch (Exception e) {
			System.out.println("[에러] 파일 읽어들이기에 실패하였습니다.");
		}
		finally {
			closeStream();
		}
	}
	
	public boolean setFile() {
		boolean result = false;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
			oos.writeObject(arrList);
			result = true;
		}
		catch (Exception e) {
			System.out.println("[에러] 파일 쓰기에 실패하였습니다.");
		}
		finally {
			closeStream();
		}
		return result;
	}
	
	public void closeStream() {
		try {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (ois != null) {
				ois.close();
			}
			if (oos != null) {
				oos.close();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
