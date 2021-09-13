import java.util.Scanner;

public class N2193 {
	static long[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		memo = new long[n + 1];
		memo[0] = 1;
		memo[1] = 1;
		System.out.print(dp(n - 1));
	}

	static long dp(int n) {
		if (n < 0) {
			return 0;
		}
		if (memo[n] > 0) {
			return memo[n];
		}
		return memo[n] = dp(n - 1) + dp(n - 2);
	}
}
