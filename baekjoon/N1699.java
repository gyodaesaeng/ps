import java.util.Scanner;

public class N1699 {
	static int n;
	static int[] memo, pows;

	public static void main(String[] args) {
		input();
		System.out.println(solve());
	}

	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
	}

	static int solve() {
		memo = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			memo[i] = 5;
		}
		int sqrt = (int) Math.sqrt(n);
		pows = new int[sqrt + 1];
		for (int i = 1; i <= sqrt; i++) {
			pows[i] = i * i;
		}
		return dp(n);
	}

	static int dp(int k) {
		if (memo[k] < 5) {
			return memo[k];
		}
		int min = 5;
		int sqrt = (int) Math.sqrt(k);
		for (int i = 1; i <= sqrt; i++) {
			min = Math.min(min, dp(k - pows[i]) + 1);
		}
		return memo[k] = min;
	}
}
