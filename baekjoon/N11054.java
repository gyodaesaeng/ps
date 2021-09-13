import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11054 {
	static int n;
	static int[] a;
	static int[][] memo;

	public static void main(String[] args) throws IOException {
		input();
		int max = 0;
		memo = new int[n][2];
		for (int i = 0; i < n; i++) {
			if (solve(i, 0) + solve(i, 1) > max) {
				max = solve(i, 0) + solve(i, 1);
			}
		}
		System.out.println(max - 1);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
	}

	static int solve(int k, int m) {
		if (memo[k][m] > 0) {
			return memo[k][m];
		}
		int max = 0;
		if (m == 0) {
			for (int i = 0; i < k; i++) {
				if (a[i] < a[k]) {
					if (solve(i, m) > max) {
						max = solve(i, m);
					}
				}
			}
		} else {
			for (int i = k + 1; i < n; i++) {
				if (a[i] < a[k]) {
					if (solve(i, m) > max) {
						max = solve(i, m);
					}
				}
			}
		}
		return memo[k][m] = max + 1;
	}
}
