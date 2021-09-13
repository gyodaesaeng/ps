import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1006 {
	static int[][][][][] memo;
	static int[][] map;
	static int n, w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new int[n][2];
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					map[k][j] = Integer.parseInt(st.nextToken());
				}
			}
			memo = new int[n][2][2][2][2];
			int min;
			if (n == 1) {
				if (map[0][0] + map[0][1] <= w) {
					min = 1;
				} else {
					min = 2;
				}
			} else {
				min = Math.min(Math.min(dp(1, 1, 1, 0, 0), dp(1, 0, 0, 1, 1)),
						Math.min(dp(1, 1, 0, 0, 1), dp(1, 0, 1, 1, 0))) + 2;
				if (map[0][0] + map[0][1] <= w) {
					min = Math.min(min, dp(1, 0, 0, 0, 0) + 1);
				}
			}
			System.out.println(min);
		}
	}

	static int dp(int a, int b, int c, int d, int e) {
		if (memo[a][b][c][d][e] > 0) {
			return memo[a][b][c][d][e];
		}
		int ans = 2;
		if (a == n - 1) {
			if ((b == 1 && map[a - 1][0] + map[a][0] <= w) || (d == 1 && map[0][0] + map[a][0] <= w)) {
				ans--;
			}
			if ((c == 1 && map[a - 1][1] + map[a][1] <= w) || (e == 1 && map[0][1] + map[a][1] <= w)) {
				ans--;
			}
			if (ans == 2 && map[a][0] + map[a][1] <= w) {
				ans--;
			}
			return memo[a][b][c][d][e] = ans;
		}
		int min = Integer.MAX_VALUE;
		if (b == 1 && map[a - 1][0] + map[a][0] <= w) {
			if (c == 1 && map[a - 1][1] + map[a][1] <= w) {
				min = dp(a + 1, 0, 0, d, e);
			}
			min = Math.min(min, dp(a + 1, 0, 1, d, e) + 1);
		}
		if (c == 1 && map[a - 1][1] + map[a][1] <= w) {
			min = Math.min(min, dp(a + 1, 1, 0, d, e) + 1);
		}
		if (map[a][0] + map[a][1] <= w) {
			min = Math.min(min, dp(a + 1, 0, 0, d, e) + 1);
		}
		min = Math.min(min, dp(a + 1, 1, 1, d, e) + 2);
		return memo[a][b][c][d][e] = min;
	}
}
