import java.util.Scanner;

public class N9663 {
	static int n;

	public static void main(String[] args) {
		input();
		System.out.println(solve(new int[n], 0));
	}

	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
	}

	static int solve(int[] last, int m) {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (qC(last, i, m)) {
				if (m == n - 1) {
					return 1;
				}
				last[m] = i;
				ans += solve(last, m + 1);
			}
		}
		return ans;
	}

	static boolean qC(int[] last, int x, int y) {
		for (int i = 0; i < y; i++) {
			if (last[i] == x || last[i] == x + y - i || last[i] == x - y + i) {
				return false;
			}
		}
		return true;
	}
}
