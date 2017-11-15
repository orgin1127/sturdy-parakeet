import java.util.Scanner;

/**
 * n개 팀 중에서 랜덤 투표
 */
public class RandomChoice2 {
	int array[];		//팀별 득표 수 
	int cnt;			//팀의 개수
	
	public static void main(String[] args) {
		new RandomChoice2();
	}

	//생성자
	public RandomChoice2() {
		//팀 생성
		input();
		
		//10표씩 30회 투표하며 화면 새로 그리기
		for (int i = 0; i < 30; i++) {
			select();
			output();
		}
		System.out.println("\n\n");
	}
	
	//팀 개수 입력받아 배열 생성
	public void input() {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			try {
				System.out.print("선택대상 개수 : ");
				cnt = scan.nextInt();
				break;
			}
			catch (Exception e) {
				System.out.println("정수를 입력하세요.");
				scan.nextLine();
			}
		}
		array = new int[cnt];
	}
	
	//n개 팀 중에서 랜덤하게 10번 투표
	public void select() {
		int n = 0;
		
		for (int i = 0; i < 10; i++) {
			n = (int)(Math.random() * cnt);
			array[n]++;
		}
	}
	
	//0.1초 간격으로 화면 새로 그리기
	public void output() {
		//cmd 창을 지운다. Eclipse의 console에서는 안됨
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//모든 팀의 득표 수 만큼 막대 차트 그리기
		String bar = null;
		System.out.println("\n\n     [ 팀별 득표 수 ]\n");

		for (int i = 0; i < cnt; i++) {
			bar = "";
			System.out.printf("%3d : ", i + 1);
			
			for (int j = 0; j < array[i]; j++) {
					bar += "■";
			}
			System.out.print(bar);
			System.out.println("(" + array[i] + ")");
		}
		
		//0.1초 대기
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
