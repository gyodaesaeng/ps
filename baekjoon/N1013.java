import java.util.Scanner;

public class N1013 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			if (solve(sc.next())) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

	static boolean solve(String s) {
		char[] chars = s.toCharArray();
		int[][] arr = { { 7, 1 }, { 2, 8 }, { 3, 8 }, { 3, 4 }, { 7, 5 }, { 6, 5 }, { 3, 0 }, { 8, 0 }, { 8, 8 } };
		int state = 0;
		for (char c : chars) {
			int index = c == '1' ? 1 : 0;
			state = arr[state][index];
		}
		return state == 0 || state == 4 || state == 5;
	}
}
