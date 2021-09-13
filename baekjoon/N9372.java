import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9372 {
	static int n, m;
	static int[][] in, union;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			input();
			System.out.println(solve());
		}
	}

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		in = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			in[i][0] = Integer.parseInt(st.nextToken());
			in[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static int solve() {
		union = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			union[i][0] = i;
			union[i][1] = 1;
		}
		int ans = 0;
		for (int i = 0; i < m; i++) {
			if (find(in[i][0]) == find(in[i][1])) {
				continue;
			}
			ans++;
			if (union(in[i][0], in[i][1]) == n) {
				return ans;
			}
		}
		return ans;
	}

	static int find(int a) {
		if (union[a][0] == a) {
			return a;
		}
		return union[a][0] = find(union[a][0]);
	}

	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		union[a][0] = b;
		return union[b][1] += union[a][1];
	}
}
