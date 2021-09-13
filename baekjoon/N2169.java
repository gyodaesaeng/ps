import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2169 {
	static int n, m;
	static int[][] map;
	static int[][][] memo;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int solve() {
		memo = new int[n][m][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 3; k++) {
					memo[i][j][k] = -100000;
				}
			}
		}
		memo[n - 1][m - 1][0] = memo[n - 1][m - 1][1] = memo[n - 1][m - 1][2] = map[n - 1][m - 1];
		return dp(0, 0, 0);
	}

	static int dp(int x, int y, int last) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return -100000;
		}
		if (memo[x][y][last] > -100000) {
			return memo[x][y][last];
		}
		int max = map[x][y] + dp(x + 1, y, 0);
		if (last != 2) {
			max = Math.max(max, map[x][y] + dp(x, y - 1, 1));
		}
		if (last != 1) {
			max = Math.max(max, map[x][y] + dp(x, y + 1, 2));
		}
		return memo[x][y][last] = max;
	}
}
