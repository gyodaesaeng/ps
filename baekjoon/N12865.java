import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12865 {
	static int n, k;
	static int[][] things;
	static int[][] memo;

	public static void main(String[] args) throws IOException {
		input();
		memo = new int[n][k + 1];
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < solve(i, k)) {
				max = solve(i, k);
			}
		}
		System.out.println(max);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		things = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken());
			things[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static int solve(int n, int k) {
		if (memo[n][k] > 0) {
			return memo[n][k];
		}
		k -= things[n][0];
		if (k < 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < solve(i, k)) {
				max = solve(i, k);
			}
		}
		return memo[n][k + things[n][0]] = max + things[n][1];
	}
}
