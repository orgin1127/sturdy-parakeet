package test;

import java.util.Random;
import java.util.Scanner;

public class Exercise6 {

	public static void main(String[] args) {
		//1~100������ ������ ���� ��� answer�� �����Ѵ�
		Random r = new Random();
		int answer = r.nextInt(100)+1;
		int input = 0;
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			count++;
			System.out.print("1�� 100������ ���� �Է��ϼ��� : ");
			input = sc.nextInt();
			if (answer == input) {
				System.out.println("������ϴ�.");
				System.out.println("�õ� Ƚ���� "+count+"�� �Դϴ�.");
				break;
			}
			else if (answer > input) {
				System.out.println("�� ū ���� �Է��ϼ���.");
			}
			else if (answer < input) {
				System.out.println("�� ���� ���� �Է��ϼ���.");
			}
		} while (true);

	}

}