import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2098 {
	static int n, m;
	static int[][] d;
	static int[][] memo;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		d = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int solve() {
		memo = new int[n][1 << n];
		for (int i = 0; i < n; i++) {
			memo[i][(1 << n) - 1] = d[i][0];
		}
		return dp(0, 1) == Integer.MAX_VALUE ? -1 : dp(0, 1);
	}

	static int dp(int c, int v) {
		if (memo[c][v] > 0) {
			return memo[c][v];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (d[c][i] > 0 && (v & (1 << i)) == 0 && dp(i, v | (1 << i)) < Integer.MAX_VALUE) {
				min = Math.min(min, dp(i, v | (1 << i)) + d[c][i]);
			}
		}
		return memo[c][v] = min;
	}
}
