import java.util.Scanner;

public class N11726 {
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		memo = new int[n + 1];
		memo[0] = 1;
		memo[1] = 1;
		System.out.print(dp(n));
	}

	static int dp(int n) {
		if (memo[n] > 0) {
			return memo[n];
		}
		return memo[n] = ((dp(n / 2) * dp(n - n / 2)) + (dp(n / 2 - 1) * dp(n - n / 2 - 1))) % 10007;
	}
}
