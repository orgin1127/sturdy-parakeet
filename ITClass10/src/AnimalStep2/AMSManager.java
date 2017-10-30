package AnimalStep2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AMSManager {
	
	ArrayList<VO> arrList;
	private final String FILENAME = "animalManagement.dat";
	FileInputStream fis = null;
	FileOutputStream fos = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	
	public AMSManager() {
		if (new File(FILENAME).exists()) {
			getFile();
		}
		else {
			arrList = new ArrayList<>();
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean getFile() {
		boolean result;
		try {
			ois = new ObjectInputStream(new FileInputStream(FILENAME));
			arrList = (ArrayList<VO>) ois.readObject();
			return result = true;
		}
		catch (Exception e) {
			System.out.println("���� �б� ����");
			e.printStackTrace();
			return result =  false;
		}
		finally {
			closeAllStream();
		}
	}
	
	public boolean setFile() {
		boolean result;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
			oos.writeObject(arrList);
			return result = true;
		}
		catch(Exception e) {
			System.out.println("���� ���� ����");
			e.printStackTrace();
			return result = false;
		}
		finally {
			closeAllStream();
		}
	}
	
	public boolean insertInformation(VO v) {
		if (searchAnimal(v.getName()) != null) {
			System.out.println("�ߺ� �̸��� ����� �Ұ��մϴ�.");
			return false;
		}
		arrList.add(v);
		return setFile();
	}
	
	public VO searchAnimal(String name) {
		for (VO vo : arrList) {
			if (vo.getName().equals(name)) {
				return vo;
			}
		}
		return null;
	}
	
	public void editAnimal(String editAnimalName) {
		Scanner sc = new Scanner(System.in);
		VO editVO = new VO();
		for (VO vo : arrList) {
			try {
				if (vo.getName().equals(editAnimalName)) {
					System.out.println("�����ϰ� ���� �׸��� �����Ͽ� �ּ���");
					System.out.println("1. �̸�");
					System.out.println("2. ǰ��");
					System.out.println("3. ����");
					System.out.println("4. ����");
					System.out.println("5. �ֽ�");
					if (vo instanceof Zookeeper) {
						System.out.println("6. �������");
						
					}
					else if  (vo instanceof CageArea) {
						System.out.println("6. ���ֱ���");
						editVO = (CageArea) vo;
					}
					else if (vo instanceof Population) {
						System.out.println("6. ��ü��");
						editVO = (Population) vo;
					}
					System.out.println("7. ��ü����");
					System.out.print("��ȣ�Է�=> ");
					int editSelect = sc.nextInt();
					sc.nextLine();
					switch (editSelect) {
						case 1:
							System.out.print("������ �̸� �Է�: ");
							String name = sc.nextLine();
							vo.setName(name);
							break;
						case 2:
							System.out.print("������ ǰ�� �Է�: ");
							String specise = sc.nextLine();
							vo.setSpecise(specise);
							break;
						case 3:
							System.out.print("������ ���� �Է�: ");
							int weight = sc.nextInt();
							sc.nextLine();
							vo.setWeight(weight);
							break;
						case 4:
							System.out.print("������ ���� �Է�: ");
							int age = sc.nextInt();
							sc.nextLine();
							vo.setAge(age);
							break;
						case 5:
							System.out.print("������ �ֽ� �Է�: ");
							String food = sc.nextLine();
							vo.setFood(food);
							break;
						case 6:
							if (vo instanceof Zookeeper) {
								editVO = (Zookeeper) vo;
								System.out.print("������ ������ �Է�: ");
								String zookeeper = sc.nextLine();
								((Zookeeper) editVO).setZookeeper(zookeeper);
								break;
							}
							else if (vo instanceof CageArea) {
								editVO = (CageArea) vo;
								System.out.print("������ ���ֱ��� �Է�: ");
								String cageArea = sc.nextLine();
								((CageArea) editVO).setCageArea(cageArea);
								break;
							}
							else if(vo instanceof Population) {
								editVO = (Population) vo;
								System.out.print("������ ��ü�� �Է�: ");
								int population = sc.nextInt();
								sc.nextLine();
								((Population) editVO).setPopulation(population);
								break;
							}
						case 7:
							System.out.print("������ �̸� �Է�: ");
							String totalNameEdit = sc.nextLine();
							vo.setName(totalNameEdit);
							System.out.print("������ ǰ�� �Է�: ");
							String totalSpeciseEdit = sc.nextLine();
							vo.setSpecise(totalSpeciseEdit);
							System.out.print("������ ���� �Է�: ");
							int totalWeightEdit = sc.nextInt();
							sc.nextLine();
							vo.setWeight(totalWeightEdit);
							System.out.print("������ ���� �Է�: ");
							int totalAgeEidt = sc.nextInt();
							sc.nextLine();
							vo.setAge(totalAgeEidt);
							System.out.print("������ �ֽ� �Է�: ");
							String totalFoodEdit = sc.nextLine();
							vo.setFood(totalFoodEdit);
							if (vo instanceof Zookeeper) {
								editVO = (Zookeeper) vo;
								System.out.print("������ ������ �Է�: ");
								String zookeeper = sc.nextLine();
								((Zookeeper) editVO).setZookeeper(zookeeper);
								break;
							}
							else if (vo instanceof CageArea) {
								editVO = (CageArea) vo;
								System.out.print("������ ���ֱ��� �Է�: ");
								String cageArea = sc.nextLine();
								((CageArea) editVO).setCageArea(cageArea);
								break;
							}
							else if(vo instanceof Population) {
								editVO = (Population) vo;
								System.out.print("������ ��ü�� �Է�: ");
								int population = sc.nextInt();
								sc.nextLine();
								((Population) editVO).setPopulation(population);
								break;
							}
					}
				}
				setFile();
			}
			catch (Exception e) {
				sc.nextLine();
			}
		}
	}
	
	public void delete(String deleteName) {
		VO deleteVO = searchAnimal(deleteName);
		if (deleteVO != null) {
			arrList.remove(deleteVO);
			System.out.println("��������");
			setFile();
			}
		else {
			System.out.println("������ ������ �����ϴ�.");
		}
		
	}
	
	public void print() {
		for (VO vo : arrList) {
			System.out.println(vo.toString());
		}
	}
	
	public void closeAllStream() {
		try {
			if (fis != null) fis.close();
			if (fos != null) fos.close();
			if (ois != null) ois.close();
			if (oos != null) oos.close();
		}
		catch (IOException e) {
			System.out.println("����� ��Ʈ�� ���� ����"); 
		}
	}

}
