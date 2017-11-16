package 정대영패키지;

public class UICompilation {
	
	public static void main(String[] args) {
		startMenu();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		joinMemberMenu();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		afterLoginMenu();
		
	}
	
	public static void afterLoginMenu() {
		System.out.println("|==============================================|");
		System.out.println("|　　　　　　　　　　　　          ログイン成功          　    　　　　　　　　　  |");
		System.out.println("|==============================================|");
		System.out.println();
		System.out.println("===============メニューを選択して下さい==================");
		System.out.println("1. N1の単語");
		System.out.println("2. N2の単語");
		System.out.println("3. N3の単語");
		System.out.print("==> ");	
	}
	
	
	public static void startMenu() {
		System.out.println("|==============================================|");
		System.out.println("|                                              |");
		System.out.println("|　　　　　　　　　　　　　　　皆の単語帳　　　　　　　　　　　　　　  |");
		System.out.println("|                                              |");
		System.out.println("|==============================================|");
		System.out.println();
		System.out.println("===============メニューを選択して下さい==================");
		System.out.println("1. アカウント登録");
		System.out.println("2. ログイン");
		System.out.print("==> ");
	}
	
	public static void joinMemberMenu() {
		System.out.println("|==============================================|");
		System.out.println("|                                              |");
		System.out.println("|　　　　　　　　　　　　　-会員登録 画面-　　　　　　　　　　　　　   |");
		System.out.println("|                                              |");
		System.out.println("|==============================================|");
		System.out.println("");
		System.out.println("===============会員登録画面に入りました。================");		
		System.out.println("今からIDとPasswordを入力します。");
	}

}
