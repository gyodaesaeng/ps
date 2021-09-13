import java.util.*;

public class N8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int combo;
		int score;
		String str;
		for (int i = 0; i < n; i++) {
			str = sc.nextLine();
			combo = 0;
			score = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'O') {
					score += ++combo;
				} else {
					combo = 0;
				}
			}
			System.out.println(score);
		}
		sc.close();
	}
}
