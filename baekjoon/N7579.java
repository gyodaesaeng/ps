import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N7579 {
	static int n, m;
	static int[][] app;
	static int[][] memo;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		app = new int[n][2];
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				app[j][i] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int solve() {
		memo = new int[10001][n];
		for (int i = 1; i < 10001; i++) {
			if (dp(i, n - 1) >= m) {
				return i;
			}
		}
		return -1;
	}

	static int dp(int w, int i) {
		if (w <= 0 || i < 0) {
			return 0;
		}
		if (memo[w][i] > 0) {
			return memo[w][i];
		}
		if (w < app[i][1]) {
			return memo[w][i] = dp(w, i - 1);
		}
		return memo[w][i] = Math.max(dp(w, i - 1), dp(w - app[i][1], i - 1) + app[i][0]);
	}
}
