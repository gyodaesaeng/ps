import java.util.Scanner;

public class N2305 {
	static long[] memo, sumMemo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		memo = new long[41];
		memo[0] = memo[1] = 1;
		sumMemo = new long[41];
		sumMemo[0] = 1;
		long ans = dp(k - 1) * dp(n - k);
		long temp = 0;
		for (int i = 1; i < k; i++) {
			temp += dp(i - 1) * dp(k - 1 - i);
			temp += sumDp(i - 2) * dp(k - 1 - i);
			temp += dp(i - 1) * sumDp(k - 2 - i);
		}
		ans += temp * dp(n - k);
		temp = 0;
		for (int i = k + 1; i <= n; i++) {
			temp += dp(i - k - 1) * dp(n - i);
			temp += sumDp(i - k - 2) * dp(n - i);
			temp += dp(i - k - 1) * sumDp(n - i - 1);
		}
		ans += temp * dp(k - 1);
		System.out.print(ans);
	}

	static long dp(int i) {
		if (memo[i] > 0) {
			return memo[i];
		}
		return memo[i] = dp(i - 2) + dp(i - 1);
	}

	static long sumDp(int i) {
		if (i < 0) {
			return 0;
		}
		if (sumMemo[i] > 0) {
			return sumMemo[i];
		}
		return sumMemo[i] = sumDp(i - 1) + dp(i);
	}
}
