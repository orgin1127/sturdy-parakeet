package test;

import java.util.regex.Pattern;

public class Exercise5 {

	public static void main(String[] args) {
		String value = "12a34";
		if (!(Pattern.matches("^[0-9]*$", value))) {
			System.out.println(value+"�� ���ڰ� �ƴմϴ�.");
		}
		else {
			System.out.println(value+"�� �����Դϴ�.");
		}

	}

}