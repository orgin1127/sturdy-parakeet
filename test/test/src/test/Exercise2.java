package test;

public class Exercise2 {

	public static void main(String[] args) {
		int total = 0;
		for (int i = 1; i <= 20; i++) {
			if ((i%2 != 0) && (i%3 != 0)){
				total = total + i;
			}
		}
		System.out.println("2의 배수도, 3의 배수도 아닌 수의 합 : "+total);
	}

}
