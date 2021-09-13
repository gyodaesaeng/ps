import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14889 {
	static int n;
	static int[][] s;

	public static void main(String[] args) throws IOException {
		input();
		int[] a = new int[n / 2];
		int[] b = new int[n / 2];
		System.out.println(solve(1, 0, 0, 1, 0, a, b));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int solve(int index, int s1, int s2, int index1, int index2, int[] a, int[] b) {
		if (index == n - 1) {
			if (index1 < n / 2) {
				for (int i = 0; i < n / 2 - 1; i++) {
					s1 += s[a[i]][index] + s[index][a[i]];
				}
			} else {
				for (int i = 0; i < n / 2 - 1; i++) {
					s2 += s[b[i]][index] + s[index][b[i]];
				}
			}
			return Math.abs(s1 - s2);
		}
		int ans = Integer.MAX_VALUE;
		if (index1 < n / 2) {
			int temp = s1;
			for (int i = 0; i < index1; i++) {
				temp += s[a[i]][index] + s[index][a[i]];
			}
			a[index1] = index;
			ans = solve(index + 1, temp, s2, index1 + 1, index2, a, b);
		}
		if (index2 < n / 2) {
			int temp = s2;
			for (int i = 0; i < index2; i++) {
				temp += s[b[i]][index] + s[index][b[i]];
			}
			b[index2] = index;
			ans = Math.min(ans, solve(index + 1, s1, temp, index1, index2 + 1, a, b));
		}
		return ans;
	}
}
