package Step3;
import java.io.*;
import java.util.*;

/**
 * <pre>
 * SES(Soft Engineer School) ���� ���α׷��� ���������� �����ϴ� Ŭ����
 * �ֿ� ������δ� ������ ����.
 * 1. �ű� �����ο� ���
 * 2. ����ο� �˻�
 * 3. ����ο� ����
 * 4. ��ü ����ο� ���
 * </pre>
 * */
public class SESManager {
	private final String FILE_NAME = "human.dat";	// ���ϸ� ���
	private ArrayList<Human> list;	// Human�� ���� ����Ʈ
	
	private FileInputStream fis;	//������ �б�����
	private FileOutputStream fos;	//������ ��������
	private ObjectInputStream ois;	//��ü�� �б�����
	private ObjectOutputStream oos;	//��ü�� ��������
	
	/**
	 * ������
	 */
	public SESManager(){
		// ������ �о���δ�
		if(new File(FILE_NAME).exists()){
			getFile();
		} else {
			list = new ArrayList<Human>();
		}
	}
	
	/**
	 * ���ο� Human ��ü�� ����Ѵ�.
	 * @param human ����� Professor, Trainee, Staff Ŭ������ ��ü
	 * @return ���� ����
	 * */
	public boolean insertHuman(Human human) {
		Human find_h = findHuman(human.getJumin());
		
		// ��ϵ� �ֹι�ȣ���� üũ�Ѵ�
		if (find_h != null) {
			return false;
		}
		
		// ���Ͽ� ���� ����Ʈ�� �����
		list.add(human);
		
		if (setFile() == false) {
			// ���� �����Ѵٸ� ��� ����� human�� ����Ʈ���� ����
			list.remove(human);
			return false;
		}
		
		return true;
	}

	/**
	 * ��ϵ� Human ��ü�� �˻��Ѵ�.
	 * @param jumin �˻��� Human�� �ֹι�ȣ
	 * @return Human �迭�� ��ϵ� ��ü�� �� �Ķ���ͷ� ���޵� �ֹι�ȣ�� ��ġ�Ǵ� Human ��ü, �˻� ����� ���� �� null�� ��ȯ�Ѵ�.
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
	 * ��ϵ� Human ��ü�� �����Ѵ�.
	 * @param jumin ������ Human�� �ֹι�ȣ
	 * @return �־��� �ֹι�ȣ�� ��ġ�Ǵ� Human ��ü�� ���� ���, Human �迭�� ��ϵ� ��ü�� �� �Ķ���ͷ� ���޵� �ֹι�ȣ�� ��ġ�Ǵ� Human ��ü�� �߰ߵǾ� ������ �����ϸ� true�� �׷��� ������ false�� ��ȯ
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
	 * ��ϵ� ��� Human ��ü ������ ����Ѵ�.
	 * */
	public void showAll() {
		Iterator<Human> it = list.iterator();
		
		while(it.hasNext()){
			it.next().showInfo();
		}
	}
	
	/**
	 * ��ϵ� ��� Human ��ü ������ ���Ͽ� ����.
	 * @return ���� ���� ���� ����
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
			System.out.println("[����] ���� ���⿡ �����߽��ϴ�.");
		} finally {
			closeStreams();
		}
		return result;
	}
	
	/**
	 * ���Ͽ� ������ ��� Human ��ü ������ �о���δ�.
	 * */
	@SuppressWarnings("unchecked")
	public void getFile() {
		try{
			// ���� ��Ʈ�����κ��� ���ϸ� �ش��ϴ� ������ �о���δ�
			fis = new FileInputStream(FILE_NAME);
			
			// ���� ��Ʈ�����κ��� ������Ʈ ��Ʈ�� ���·� ����
			ois = new ObjectInputStream(fis);
			
			// ������Ʈ ��Ʈ�����κ��� ������Ʈ�� �о� ArrayList<Human>���� ����ȯ
			list = (ArrayList<Human>) ois.readObject();
		} catch(Exception e) {
			// e.printStackTrace();
			System.out.println("[����] ���� �б⿡ �����Ͽ����ϴ�.");
		} finally {
			closeStreams();
		}
	}
	
	/**
	 * ��Ʈ�� ��ü�� close �Ͽ� �ڿ��� ��ȯ�Ѵ�.
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
