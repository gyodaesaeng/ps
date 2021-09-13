import java.util.Scanner;

public class N10870 {
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		memo = new int[n + 2];
		memo[0] = 0;
		memo[1] = 1;
		System.out.println(dp(n));
	}

	static int dp(int n) {
		if (memo[n] > 0 || n == 0) {
			return memo[n];
		}
		return memo[n] = dp(n - 1) + dp(n - 2);
	}
}
