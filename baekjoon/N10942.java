import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N10942 {
	static int n, m;
	static int[] a;
	static int[][] b;
	static boolean[][][] memo;

	public static void main(String[] args) throws IOException {
		input();
		output(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		b = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static boolean[] solve() {
		boolean[] ans = new boolean[m];
		memo = new boolean[n][n][2];
		for (int i = 0; i < m; i++) {
			ans[i] = dp(b[i][0] - 1, b[i][1] - 1);
		}
		return ans;
	}

	static boolean dp(int s, int e) {
		if (memo[s][e][0]) {
			return memo[s][e][1];
		}
		memo[s][e][0] = true;
		if (s >= e) {
			return memo[s][e][1] = true;
		}
		if (a[s] == a[e]) {
			return memo[s][e][1] = dp(s + 1, e - 1);
		}
		return memo[s][e][1] = false;
	}

	static void output(boolean[] ans) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (boolean i : ans) {
			if (i) {
				bw.write('1');
			} else {
				bw.write('0');
			}
			bw.newLine();
		}
		bw.flush();
	}
}
