import java.util.Scanner;

/**
 * n�� �� �߿��� ���� ��ǥ
 */
public class RandomChoice2 {
	int array[];		//���� ��ǥ �� 
	int cnt;			//���� ����
	
	public static void main(String[] args) {
		new RandomChoice2();
	}

	//������
	public RandomChoice2() {
		//�� ����
		input();
		
		//10ǥ�� 30ȸ ��ǥ�ϸ� ȭ�� ���� �׸���
		for (int i = 0; i < 30; i++) {
			select();
			output();
		}
		System.out.println("\n\n");
	}
	
	//�� ���� �Է¹޾� �迭 ����
	public void input() {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			try {
				System.out.print("���ô�� ���� : ");
				cnt = scan.nextInt();
				break;
			}
			catch (Exception e) {
				System.out.println("������ �Է��ϼ���.");
				scan.nextLine();
			}
		}
		array = new int[cnt];
	}
	
	//n�� �� �߿��� �����ϰ� 10�� ��ǥ
	public void select() {
		int n = 0;
		
		for (int i = 0; i < 10; i++) {
			n = (int)(Math.random() * cnt);
			array[n]++;
		}
	}
	
	//0.1�� �������� ȭ�� ���� �׸���
	public void output() {
		//cmd â�� �����. Eclipse�� console������ �ȵ�
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//��� ���� ��ǥ �� ��ŭ ���� ��Ʈ �׸���
		String bar = null;
		System.out.println("\n\n     [ ���� ��ǥ �� ]\n");

		for (int i = 0; i < cnt; i++) {
			bar = "";
			System.out.printf("%3d : ", i + 1);
			
			for (int j = 0; j < array[i]; j++) {
					bar += "��";
			}
			System.out.print(bar);
			System.out.println("(" + array[i] + ")");
		}
		
		//0.1�� ���
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
