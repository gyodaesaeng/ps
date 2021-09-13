import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11657 {
	static final int INF = 5000000;
	static int n, m;
	static int[] d;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				map[i][j] = INF;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(map[a][b], c);
		}
	}

	static void solve() {
		d = new int[n + 1];
		Arrays.fill(d, INF);
		d[1] = 0;
		boolean update = false;
		for (int i = 0; i < n; i++) {
			update = false;
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (map[j][k] < INF && d[j] < INF && map[j][k] + d[j] < d[k]) {
						d[k] = map[j][k] + d[j];
						update = true;
					}
				}
			}
			if (!update) {
				break;
			}
		}
		if (update) {
			d[0] = -1;
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if (d[0] == -1) {
			bw.write("-1");
			bw.flush();
			return;
		}
		for (int i = 2; i <= n; i++) {
			if (d[i] == INF) {
				bw.write("-1\n");
			} else {
				bw.write(d[i] + "\n");
			}
		}
		bw.flush();
	}
}
