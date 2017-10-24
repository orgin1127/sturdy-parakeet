package Test1024_ooptest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOTest6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean flag1 = true;
		int count = 1;
		String select;
		StringBuffer sb = new StringBuffer();
		boolean flag = true;
		
		System.out.println("내용을 입력하세요.");
		while(flag1) {
			System.out.print(count+" : ");
			str = sc.nextLine();
			if (str.isEmpty()) {
				break;
			}
			sb.append(str);
			sb.append("\r"+"\n");
			count++;
		}
		
		System.out.print("저장하시겠습니까? (y/n) ");
		select = sc.nextLine();
		
		if (select.equals("y")) {
			while (flag) {
				System.out.print("파일명 : ");
				String filename = sc.nextLine();
				
				if (new File(filename).exists()) {
					System.out.print("이미 존재하는 파일명입니다. 덮어쓰시겠습니까? (y/n) ");
					String select2 = sc.nextLine();
					if (select2.equals("y")) {
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
							bw.write(sb.toString());
							flag = false;
							bw.close();
							System.out.println(filename+" 파일이 생성되었습니다.");
						}
						catch (IOException e) {
							System.out.println("파일 덮어쓰기에 실패하였습니다.");				
						}
					}
					else if (select2.equals("n")) {
						continue;
					}
				}
				else {
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
						bw.write(sb.toString());
						flag = false;
						bw.close();
						System.out.println(filename+" 파일이 생성되었습니다.");
					}
					catch (IOException e) {
						System.out.println("파일 생성에 실패하였습니다.");				
					}
				}
				
			}//while
		}
		else {
			sc.close();
			System.out.println("저장하지 않고 종료합니다.");
		}
		
	}
}

/**
 * 내용을 입력하세요.
 * 1: 가나다라
 * 2: abcd
 * 3:
 * 저장하시겠습니까? (y/n) y
 * 파일명 : a.txt
 * 이미 존재하는 파일명입니다. 덮어쓰시겠습니까? (y/n) n
 * 파일명  : b.txt
 * 
 * b.txt 파일이 저장되었습니다.
 */