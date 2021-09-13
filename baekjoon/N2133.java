import java.util.Scanner;

public class N2133 {
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		memo = new int[n + 1];
		memo[0] = 1;
		System.out.print(dp(n));
	}

	static int dp(int n) {
		if (n < 0 || n % 2 > 0) {
			return 0;
		}
		if (memo[n] > 0) {
			return memo[n];
		}
		memo[n] = dp(n - 2) * 3;
		for (int i = n - 4; i >= 0; i -= 2) {
			memo[n] += dp(i) * 2;
		}
		return memo[n];
	}
}
