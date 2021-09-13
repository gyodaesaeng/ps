import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N17472 {
	static int n, m, k;
	static boolean[][] map;
	static int[][] a, road;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = st.nextToken().equals("1");
			}
		}
	}

	static void solve() {
		a = new int[n][m];
		k = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j]) {
					findNear(k++, i, j);
				}
			}
		}
		road = new int[k][k];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				road[i][j] = 11;
			}
		}
		for (int i = 0; i < n; i++) {
			int s = 0;
			int si = 0;
			for (int j = 0; j < m; j++) {
				if (a[i][j] > 0) {
					if (s == 0) {
						s = a[i][j];
						si = j;
					} else if (s == a[i][j]) {
						si = j;
					} else {
						if (j - si > 2) {
							road[s][a[i][j]] = Math.min(j - si - 1, road[s][a[i][j]]);
							road[a[i][j]][s] = road[s][a[i][j]];
						}
						s = a[i][j];
						si = j;
					}
				}
			}
		}
		for (int i = 0; i < m; i++) {
			int s = 0;
			int si = 0;
			for (int j = 0; j < n; j++) {
				if (a[j][i] > 0) {
					if (s == 0) {
						s = a[j][i];
						si = j;
					} else if (s == a[j][i]) {
						si = j;
					} else {
						if (j - si > 2) {
							road[s][a[j][i]] = Math.min(j - si - 1, road[s][a[j][i]]);
							road[a[j][i]][s] = road[s][a[j][i]];
						}
						s = a[j][i];
						si = j;
					}
				}
			}
		}
		ArrayList<V> vs = new ArrayList<V>();
		for (int i = 1; i < k; i++) {
			for (int j = i + 1; j < k; j++) {
				if (road[i][j] < 10) {
					vs.add(new V(i, j, road[i][j]));
				}
			}
		}
		Collections.sort(vs);
		boolean[][] connect = new boolean[k][k];
		int count = 0;
		int sum = 0;
		for (V i : vs) {
			if (connect[i.s][i.e]) {
				continue;
			}
			count++;
			sum += i.l;
			connect[i.e][i.s] = connect[i.s][i.e] = true;
			for (int j = 1; j < k; j++) {
				connect[j][i.e] = connect[j][i.s] = connect[i.e][j] = connect[i.s][j] = connect[i.s][j]
						|| connect[i.e][j];
			}
			if (count == k - 2) {
				break;
			}
		}
		if (count == k - 2) {
			System.out.println(sum);
		} else {
			System.out.println(-1);
		}
	}

	static void findNear(int islandN, int x, int y) {
		if (x < 0 || x == n || y < 0 || y == m) {
			return;
		}
		if (map[x][y]) {
			a[x][y] = islandN;
			map[x][y] = false;
			findNear(islandN, x + 1, y);
			findNear(islandN, x - 1, y);
			findNear(islandN, x, y + 1);
			findNear(islandN, x, y - 1);
		}
	}

}

class V implements Comparable<V> {
	int s, e, l;

	V(int s, int e, int l) {
		this.s = s;
		this.e = e;
		this.l = l;
	}

	@Override
	public int compareTo(V v) {
		if (l > v.l) {
			return 1;
		} else {
			return -1;
		}
	}
}
