import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11049 {
	static int n;
	static int[] m;
	static int[][] memo;// [Ω√¿€][≥°]

	public static void main(String[] args) throws IOException {
		input();
		memo = new int[n + 1][n + 1];
		System.out.println(solve(0, n));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = new int[n + 1];
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			m[i] = Integer.parseInt(st.nextToken());
		}
		m[n] = Integer.parseInt(st.nextToken());
	}

	static int solve(int s, int e) {
		if (memo[s][e] > 0) {
			return memo[s][e];
		}
		if (e - s == 2) {
			return memo[s][e] = m[s] * m[s + 1] * m[e];
		}
		if (e - s < 2) {
			return memo[s][e] = 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = s + 1; i < e; i++) {
			if (min > solve(s, i) + solve(i, e) + m[s] * m[i] * m[e]) {
				min = solve(s, i) + solve(i, e) + m[s] * m[i] * m[e];
			}
		}
		return memo[s][e] = min;
	}
}
