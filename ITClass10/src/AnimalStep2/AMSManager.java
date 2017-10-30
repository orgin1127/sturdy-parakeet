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
			System.out.println("파일 읽기 실패");
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
			System.out.println("파일 쓰기 실패");
			e.printStackTrace();
			return result = false;
		}
		finally {
			closeAllStream();
		}
	}
	
	public boolean insertInformation(VO v) {
		if (searchAnimal(v.getName()) != null) {
			System.out.println("중복 이름은 등록이 불가합니다.");
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
					System.out.println("수정하고 싶은 항목을 선택하여 주세요");
					System.out.println("1. 이름");
					System.out.println("2. 품종");
					System.out.println("3. 무게");
					System.out.println("4. 나이");
					System.out.println("5. 주식");
					if (vo instanceof Zookeeper) {
						System.out.println("6. 사육사명");
						
					}
					else if  (vo instanceof CageArea) {
						System.out.println("6. 거주구역");
						editVO = (CageArea) vo;
					}
					else if (vo instanceof Population) {
						System.out.println("6. 개체수");
						editVO = (Population) vo;
					}
					System.out.println("7. 전체수정");
					System.out.print("번호입력=> ");
					int editSelect = sc.nextInt();
					sc.nextLine();
					switch (editSelect) {
						case 1:
							System.out.print("수정할 이름 입력: ");
							String name = sc.nextLine();
							vo.setName(name);
							break;
						case 2:
							System.out.print("수정할 품종 입력: ");
							String specise = sc.nextLine();
							vo.setSpecise(specise);
							break;
						case 3:
							System.out.print("수정할 무게 입력: ");
							int weight = sc.nextInt();
							sc.nextLine();
							vo.setWeight(weight);
							break;
						case 4:
							System.out.print("수정할 나이 입력: ");
							int age = sc.nextInt();
							sc.nextLine();
							vo.setAge(age);
							break;
						case 5:
							System.out.print("수정할 주식 입력: ");
							String food = sc.nextLine();
							vo.setFood(food);
							break;
						case 6:
							if (vo instanceof Zookeeper) {
								editVO = (Zookeeper) vo;
								System.out.print("수정할 사육사 입력: ");
								String zookeeper = sc.nextLine();
								((Zookeeper) editVO).setZookeeper(zookeeper);
								break;
							}
							else if (vo instanceof CageArea) {
								editVO = (CageArea) vo;
								System.out.print("수정할 거주구역 입력: ");
								String cageArea = sc.nextLine();
								((CageArea) editVO).setCageArea(cageArea);
								break;
							}
							else if(vo instanceof Population) {
								editVO = (Population) vo;
								System.out.print("수정할 개체수 입력: ");
								int population = sc.nextInt();
								sc.nextLine();
								((Population) editVO).setPopulation(population);
								break;
							}
						case 7:
							System.out.print("수정할 이름 입력: ");
							String totalNameEdit = sc.nextLine();
							vo.setName(totalNameEdit);
							System.out.print("수정할 품종 입력: ");
							String totalSpeciseEdit = sc.nextLine();
							vo.setSpecise(totalSpeciseEdit);
							System.out.print("수정할 무게 입력: ");
							int totalWeightEdit = sc.nextInt();
							sc.nextLine();
							vo.setWeight(totalWeightEdit);
							System.out.print("수정할 나이 입력: ");
							int totalAgeEidt = sc.nextInt();
							sc.nextLine();
							vo.setAge(totalAgeEidt);
							System.out.print("수정할 주식 입력: ");
							String totalFoodEdit = sc.nextLine();
							vo.setFood(totalFoodEdit);
							if (vo instanceof Zookeeper) {
								editVO = (Zookeeper) vo;
								System.out.print("수정할 사육사 입력: ");
								String zookeeper = sc.nextLine();
								((Zookeeper) editVO).setZookeeper(zookeeper);
								break;
							}
							else if (vo instanceof CageArea) {
								editVO = (CageArea) vo;
								System.out.print("수정할 거주구역 입력: ");
								String cageArea = sc.nextLine();
								((CageArea) editVO).setCageArea(cageArea);
								break;
							}
							else if(vo instanceof Population) {
								editVO = (Population) vo;
								System.out.print("수정할 개체수 입력: ");
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
			System.out.println("삭제성공");
			setFile();
			}
		else {
			System.out.println("삭제할 동물이 없습니다.");
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
			System.out.println("입출력 스트림 종료 실패"); 
		}
	}

}
