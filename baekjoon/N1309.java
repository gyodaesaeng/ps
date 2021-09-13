import java.util.Scanner;

public class N1309 {
	static int[][] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		memo = new int[n + 1][2];
		memo[0][0] = memo[0][1] = 1;
		memo[1][0] = 2;
		memo[1][1] = 1;
		System.out.print((dp(n, 0) + dp(n, 1)) % 9901);
	}

	static int dp(int m, int last) {
		if (memo[m][last] > 0) {
			return memo[m][last];
		}
		if (last == 1) {
			return memo[m][last] = (dp(m - 1, 1) + dp(m - 1, 0)) % 9901;
		} else {
			return memo[m][last] = (2 * dp(m - 1, 1) + dp(m - 1, 0)) % 9901;
		}
	}
}
