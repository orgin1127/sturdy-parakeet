package User.UI2;

public class UICompilation {
	
	public void afterLoginMenu() {
		System.out.println("|==============================================|");
		System.out.println("|　　　　　　　　　　　　          ログイン成功          　    　　　　            　　  |");
		System.out.println("|==============================================|");
		System.out.println();
		System.out.println("===============メニューを選択して下さい==================");
		System.out.println("1. N1の単語");
		System.out.println("2. N2の単語");
		System.out.println("3. N3の単語");
		System.out.println("4. カスタム単語");
		System.out.println("0. ログアウト");
		System.out.print("==> ");	
	}
	
	
	public void startMenu() {
		System.out.println("|==============================================|");
		System.out.println("|                                              |");
		System.out.println("|　　　　　　　　　　　　　　　皆の単語帳　　　　　　　　　        　　　  |");
		System.out.println("|                                              |");
		System.out.println("|==============================================|");
		System.out.println();
		System.out.println("===============メニューを選択して下さい==================");
		System.out.println("1. アカウント登録");
		System.out.println("2. ログイン");
		System.out.println("0. プログラム終了");
		System.out.print("==> ");
	}
	
	public void joinMemberMenu() {
		System.out.println("|==============================================|");
		System.out.println("|                                              |");
		System.out.println("|　　　　　　　　　　　　　-会員登録 画面-　　　　　　　　　        　　   |");
		System.out.println("|                                              |");
		System.out.println("|==============================================|");
		System.out.println("");
		System.out.println("===============会員登録画面に入りました。================");		
		System.out.println("今からIDとPasswordを入力します。");
	}
	
	public static void clear() {
		for (int i = 0; i < 35; i++) {
			System.out.println("");
		}
	}

}
