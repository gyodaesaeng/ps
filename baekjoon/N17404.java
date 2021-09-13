import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17404 {
	static int n;
	static int[][] in;
	static int[][][] memo;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				in[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int solve() {
		memo = new int[n][3][3];
		int min = Integer.MAX_VALUE;
		if (n == 0) {
			return 0;
		}
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dp(1, i, i) + in[0][i]);
		}
		return min;
	}

	static int dp(int index, int s, int l) {
		if (index >= n) {
			return 0;
		}
		if (memo[index][s][l] > 0) {
			return memo[index][s][l];
		}
		int min = Integer.MAX_VALUE;
		if (index == n - 1) {
			for (int i = 0; i < 3; i++) {
				if (i != s && i != l) {
					min = Math.min(min, in[index][i]);
				}
			}
			return min;
		}
		for (int i = 0; i < 3; i++) {
			if (i == l) {
				continue;
			}
			min = Math.min(min, dp(index + 1, s, i) + in[index][i]);
		}
		return memo[index][s][l] = min;
	}
}
