import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1014 {
	static int n, m, memo[][][];
	static boolean map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		for (int i = 0; i < c; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new boolean[n][m + 1];
			memo = new int[n][m + 1][1 << (m + 2)];
			for (int j = 0; j < n; j++) {
				char in[] = br.readLine().toCharArray();
				for (int k = 1; k <= m; k++) {
					map[j][k] = in[k - 1] == '.';
					Arrays.fill(memo[j][k], -1);
				}
			}
			System.out.println(dp(0, 1, 0));
		}
	}

	static int dp(int a, int b, int c) {
		if (b > m) {
			if (a == n - 1) {
				return 0;
			}
			return dp(a + 1, 1, c);
		}
		if (memo[a][b][c] < 0) {
			memo[a][b][c] = dp(a, b + 1, c - (c & (1 << b)));
			if (map[a][b] && (c & (1 << b)) == 0) {
				memo[a][b][c] = Math.max(memo[a][b][c], dp(a, b + 2, c | (1 << (b - 1)) | (1 << (b + 1))) + 1);
			}
		}
		return memo[a][b][c];
	}
}
