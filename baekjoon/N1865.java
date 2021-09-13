import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1865 {
	static final int INF = 5000000;
	static int t, n, m, w;
	static int[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			input();
			if (solve()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = INF;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			map[s][e] = map[e][s] = Math.min(map[s][e], t);
		}
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			map[s][e] = Math.min(map[s][e], -t);
		}
	}

	static boolean solve() {
		int[] d = new int[n + 1];
		Arrays.fill(d, INF);
		d[1] = 0;
		boolean update = false;
		for (int i = 0; i < n; i++) {
			update = false;
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (map[j][k] < INF && d[j] < INF && map[j][k] + d[j] < d[k]) {
						d[k] = d[j] + map[j][k];
						update = true;
					}
				}
			}
			if (!update) {
				break;
			}
		}
		return update;
	}
}
