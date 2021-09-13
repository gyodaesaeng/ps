import java.util.Arrays;
import java.util.Scanner;

public class N2482 {
	static final int mod = 1000000003;
	static int n, k;
	static int[][] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		sc.close();
		System.out.print(solve());
	}

	static long solve() {
		memo = new int[n - 1][k + 1];
		for (int i = 0; i < n - 1; i++) {
			Arrays.fill(memo[i], Integer.MAX_VALUE);
		}
		return (long) (dp(0, k) + dp(2, k - 1)) % mod;
	}

	static int dp(int index, int picked) {
		if (picked == 0) {
			return 1;
		}
		if (index >= n - 1) {
			return 0;
		}
		if (memo[index][picked] < Integer.MAX_VALUE) {
			return memo[index][picked];
		}
		return memo[index][picked] = (int) ((long) (dp(index + 1, picked) + dp(index + 2, picked - 1)) % mod);

	}
}
