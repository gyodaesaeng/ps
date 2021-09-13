import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1976 {
	static int n, m;
	static int[] path, parent;
	static boolean[][] in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve() ? "YES" : "NO");
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		in = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				in[i][j] = st.nextToken().charAt(0) == '1';
			}
		}
		path = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			path[i] = Integer.parseInt(st.nextToken());
		}
	}

	static boolean solve() {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (in[i][j]) {
					union(i, j);
				}
			}
		}
		for (int i = 1; i < m; i++) {
			if (find(path[0] - 1) != find(path[i] - 1)) {
				return false;
			}
		}
		return true;
	}

	static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		parent[find(a)] = parent[find(b)];
	}
}
