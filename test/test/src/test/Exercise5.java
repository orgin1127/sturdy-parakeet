package test;

import java.util.regex.Pattern;

public class Exercise5 {

	public static void main(String[] args) {
		String value = "12a34";
		if (!(Pattern.matches("^[0-9]*$", value))) {
			System.out.println(value+"는 숫자가 아닙니다.");
		}
		else {
			System.out.println(value+"는 숫자입니다.");
		}

	}

}
