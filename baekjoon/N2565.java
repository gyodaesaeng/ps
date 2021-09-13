import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2565 {
	static int n;
	static int[] a;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		input();
		memo = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < solve(i)) {
				max = solve(i);
			}
		}
		System.out.println(n - max);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] b = new int[501];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			b[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		a = new int[n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			while (b[index] == 0) {
				index++;
			}
			a[i] = b[index++];
		}
	}

	static int solve(int n) {
		if (memo[n] > 0) {
			return memo[n];
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < solve(i) && a[i] < a[n]) {
				max = solve(i);
			}
		}
		return memo[n] = max + 1;
	}
}
