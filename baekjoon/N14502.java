import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N14502 {
	static int n, m;
	static int[][] map;
	static ArrayList<Co> blank, virus;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		blank = new ArrayList<Co>();
		virus = new ArrayList<Co>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					blank.add(new Co(i, j));
				}
				if (map[i][j] == 2) {
					virus.add(new Co(i, j));
				}
			}
		}
		int max = 0;
		for (int i = 0; i < blank.size(); i++) {
			map[blank.get(i).x][blank.get(i).y] = 1;
			for (int j = i + 1; j < blank.size(); j++) {
				map[blank.get(j).x][blank.get(j).y] = 1;
				for (int k = j + 1; k < blank.size(); k++) {
					map[blank.get(k).x][blank.get(k).y] = 1;
					int temp = safebox();
					if (temp > max) {
						max = temp;
					}
					map[blank.get(k).x][blank.get(k).y] = 0;
				}
				map[blank.get(j).x][blank.get(j).y] = 0;
			}
			map[blank.get(i).x][blank.get(i).y] = 0;
		}
		System.out.println(max);
	}

	static int safebox() {
		for (Co i : virus) {
			spread(i.x - 1, i.y);
			spread(i.x + 1, i.y);
			spread(i.x, i.y - 1);
			spread(i.x, i.y + 1);
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					ans++;
				} else if (map[i][j] == 3) {
					map[i][j] = 0;
				}
			}
		}
		return ans;
	}

	static void spread(int x, int y) {
		if (x < 0 || y < 0 || x == n || y == m) {
			return;
		}
		if (map[x][y] == 0) {
			map[x][y] = 3;
			spread(x - 1, y);
			spread(x + 1, y);
			spread(x, y - 1);
			spread(x, y + 1);
		}
	}
}

class Co {
	int x, y;

	Co(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
