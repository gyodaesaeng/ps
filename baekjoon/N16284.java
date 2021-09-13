import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16284 {
	static int n, l, m, w;
	static int[][] t, p;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		t = new int[m][n];
		p = new int[m][l];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				t[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < l; j++) {
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int solve() {
		int[][] multi = new int[101][101];
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				multi[i][j] = i * j;
			}
		}
		int ans = 0;
		for (int i = 0; i <= n - l; i++) {
			int sum = 0;
			for (int j = 0; j < l; j++) {
				for (int k = 0; k < m; k++) {
					sum += multi[t[k][i + j]][p[k][j]];
				}
			}
			if (sum > w) {
				ans++;
			}
		}
		return ans;
	}
}
