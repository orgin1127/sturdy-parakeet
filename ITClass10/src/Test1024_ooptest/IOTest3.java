package Test1024_ooptest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File f;
		
		boolean flag1 = true;
		boolean flag2 = true;
		String filename="";
		String content;
		int count = 1;
		
		while (flag1) {
			System.out.print("저장할 파일명 : ");
			filename = sc.nextLine();
			if (new File(filename).exists()) {
				System.out.println("이미 존재하는 파일입니다.");
				continue;
			}
			else {
				flag1 = false;
			}
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			System.out.println("내용을 입력하세요.");
			while (flag2) {
				System.out.print(count+":");
				content = sc.nextLine();
				if (content.isEmpty()) {
					flag2 = false;
					break;
				}
				count++;
				bw.write(content);
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(filename+"이 생성되었습니다.");
		
	}

}
