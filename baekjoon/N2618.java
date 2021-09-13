import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2618 {
	static int n, w;
	static int[][] loc;
	static int[][] memo;
	static boolean[][] memoCar;

	public static void main(String[] args) throws IOException {
		input();
		output(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = Integer.parseInt(br.readLine());
		loc = new int[w + 1][2];
		for (int i = 1; i <= w; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			loc[i][0] = Integer.parseInt(st.nextToken());
			loc[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static int[] solve() {
		int[] ans = new int[w + 1];
		memo = new int[w + 1][w + 1];
		memoCar = new boolean[w][w];
		for (int i = 0; i <= w; i++) {
			for (int j = 0; j <= w; j++) {
				memo[i][j] = Integer.MAX_VALUE;
			}
		}
		ans[0] = dp(0, 0);
		int a = 0;
		int b = 0;
		for (int i = 1; i <= w; i++) {
			int c = Math.max(a, b);
			if (memoCar[a][b]) {
				ans[i] = 1;
				a = c + 1;
			} else {
				ans[i] = 2;
				b = c + 1;
			}
		}
		return ans;
	}

	static void output(int[] ans) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i : ans) {
			bw.write(i + "\n");
		}
		bw.flush();
	}

	static int dp(int a, int b) {
		if (memo[a][b] < Integer.MAX_VALUE) {
			return memo[a][b];
		}
		int c = Math.max(a, b);
		if (c == w) {
			return memo[a][b] = 0;
		}
		if (dp(c + 1, b) + len(a, c + 1, true) < dp(a, c + 1) + len(b, c + 1, false)) {
			memoCar[a][b] = true;
			return memo[a][b] = dp(c + 1, b) + len(a, c + 1, true);
		} else {
			memoCar[a][b] = false;
			return memo[a][b] = dp(a, c + 1) + len(b, c + 1, false);
		}
	}

	static int len(int a, int b, boolean c) {
		if (a == 0) {
			if (c) {
				return loc[b][0] + loc[b][1] - 2;
			} else {
				return n * 2 - loc[b][0] - loc[b][1];
			}
		}
		return Math.abs(loc[a][0] - loc[b][0]) + Math.abs(loc[a][1] - loc[b][1]);
	}
}
