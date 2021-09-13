import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1029 {
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
		in = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				in[i][j] = s.charAt(j) - '0';
			}
		}
	}

	static int solve() {
		memo = new int[1 << n][n][10];
		for (int i = 0; i < n; i++) {
			Arrays.fill(memo[(1 << n) - 1][i], 1);
		}
		return dp(1, 0, 0);
	}

	static int dp(int check, int now, int price) {
		if (memo[check][now][price] > 0) {
			return memo[check][now][price];
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			if ((check & (1 << i)) == 0 && in[now][i] >= price) {
				max = Math.max(max, dp(check | (1 << i), i, in[now][i]));
			}
		}
		return memo[check][now][price] = max + 1;
	}
}
