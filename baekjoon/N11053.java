import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11053 {
	static int n;
	static int[] a;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		input();
		int max = 1;
		memo = new int[n];
		for (int i = 1; i < n; i++) {
			if (solve(i) > max) {
				max = solve(i);
			}

		}
		System.out.println(max);
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

	static int solve(int n) {
		if (memo[n] > 0) {
			return memo[n];
		}
		memo[n] = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] < a[n] && solve(i) > memo[n]) {
				memo[n] = solve(i);
			}
		}
		memo[n]++;
		return memo[n];
	}
}
