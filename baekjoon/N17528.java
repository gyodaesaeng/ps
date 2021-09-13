import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17528 {
	static int n;
	static int[] a, b;
	static int[][] memo;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		b = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
	}

	static int solve() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += b[i];
		}
		memo = new int[62501][n];
		int min = 62500;
		for (int i = 1; i < 62501; i++) {
			if (min > Math.max(i, sum - dp(i, n - 1))) {
				min = Math.max(i, sum - dp(i, n - 1));
			}
		}
		return min;
	}

	static int dp(int sum, int m) {
		if (m == -1) {
			return 0;
		}
		if (memo[sum][m] > 0) {
			return memo[sum][m];
		}
		if (sum - a[m] < 0) {
			return memo[sum][m] = dp(sum, m - 1);
		}
		return memo[sum][m] = Math.max(dp(sum, m - 1), dp(sum - a[m], m - 1) + b[m]);
	}
}
