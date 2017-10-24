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
		
		System.out.println("������ �Է��ϼ���.");
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
		
		System.out.print("�����Ͻðڽ��ϱ�? (y/n) ");
		select = sc.nextLine();
		
		if (select.equals("y")) {
			while (flag) {
				System.out.print("���ϸ� : ");
				String filename = sc.nextLine();
				
				if (new File(filename).exists()) {
					System.out.print("�̹� �����ϴ� ���ϸ��Դϴ�. ����ðڽ��ϱ�? (y/n) ");
					String select2 = sc.nextLine();
					if (select2.equals("y")) {
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
							bw.write(sb.toString());
							flag = false;
							bw.close();
							System.out.println(filename+" ������ �����Ǿ����ϴ�.");
						}
						catch (IOException e) {
							System.out.println("���� ����⿡ �����Ͽ����ϴ�.");				
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
						System.out.println(filename+" ������ �����Ǿ����ϴ�.");
					}
					catch (IOException e) {
						System.out.println("���� ������ �����Ͽ����ϴ�.");				
					}
				}
				
			}//while
		}
		else {
			sc.close();
			System.out.println("�������� �ʰ� �����մϴ�.");
		}
		
	}
}

/**
 * ������ �Է��ϼ���.
 * 1: �����ٶ�
 * 2: abcd
 * 3:
 * �����Ͻðڽ��ϱ�? (y/n) y
 * ���ϸ� : a.txt
 * �̹� �����ϴ� ���ϸ��Դϴ�. ����ðڽ��ϱ�? (y/n) n
 * ���ϸ�  : b.txt
 * 
 * b.txt ������ ����Ǿ����ϴ�.
 */