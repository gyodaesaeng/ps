import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14501 {
	static int n;
	static int[][] in;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			in[i][0] = Integer.parseInt(st.nextToken());
			in[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static int solve() {
		memo = new int[n + 1];
		Arrays.fill(memo, -1);
		memo[n] = 0;
		return dp(0);
	}

	static int dp(int i) {
		if (i > n) {
			return Integer.MIN_VALUE;
		}
		if (memo[i] > -1) {
			return memo[i];
		}
		return memo[i] = Math.max(in[i][1] + dp(i + in[i][0]), dp(i + 1));
	}
}
