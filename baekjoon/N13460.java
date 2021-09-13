import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N13460 {
	static int n, m;
	static int[][] map;
	static int[] r, b;
	static int[][][] length;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		r = new int[2];
		b = new int[2];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				switch (s.charAt(j)) {
				case '#':
					map[i][j] = 1;
					break;
				case '.':
					map[i][j] = 0;
					break;
				case 'O':
					map[i][j] = 2;
					break;
				case 'R':
					map[i][j] = 0;
					r[0] = i;
					r[1] = j;
					break;
				case 'B':
					map[i][j] = 0;
					b[0] = i;
					b[1] = j;
					break;
				}
			}
		}
	}

	static int solve() {
		find();
		int ans = Math.min(bt(0, true), bt(0, false));
		if (ans > 10) {
			ans = -1;
		}
		return ans;
	}

	static void find() {
		length = new int[n][m][4];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					for (int k = i + 1; k < n; k++) {
						if (map[k][j] == 2) {
							length[i][j][0] = -1;
							break;
						}
						if (map[k][j] == 1) {
							length[i][j][0] = k - 1;
							break;
						}
					}
					for (int k = i - 1; k >= 0; k--) {
						if (map[k][j] == 2) {
							length[i][j][1] = -1;
							break;
						}
						if (map[k][j] == 1) {
							length[i][j][1] = k + 1;
							break;
						}
					}
					for (int k = j + 1; k < m; k++) {
						if (map[i][k] == 2) {
							length[i][j][2] = -1;
							break;
						}
						if (map[i][k] == 1) {
							length[i][j][2] = k - 1;
							break;
						}
					}
					for (int k = j - 1; k >= 0; k--) {
						if (map[i][k] == 2) {
							length[i][j][3] = -1;
							break;
						}
						if (map[i][k] == 1) {
							length[i][j][3] = k + 1;
							break;
						}
					}
				}
			}
		}
	}

	static int bt(int k, boolean width) {
		int min = 11;
		if (k > 10) {
			return 11;
		}
		if (width) {
			for (int i = 0; i < 2; i++) {
				if (length[b[0]][b[1]][i] == -1) {
					continue;
				}
				if (length[r[0]][r[1]][i] == -1) {
					min = Math.min(min, k + 1);
					continue;
				}
				if (length[b[0]][b[1]][i] == b[0] && length[r[0]][r[1]][i] == r[0]) {
					continue;
				}
				int tempb = b[0];
				int tempr = r[0];
				if (length[b[0]][b[1]][i] == length[r[0]][r[1]][i] && b[1] == r[1]) {
					if (b[0] > r[0]) {
						b[0] = length[b[0]][b[1]][i] + i;
						r[0] = length[r[0]][r[1]][i] - 1 + i;
					} else {
						b[0] = length[b[0]][b[1]][i] - 1 + i;
						r[0] = length[r[0]][r[1]][i] + i;
					}
				} else {
					b[0] = length[b[0]][b[1]][i];
					r[0] = length[r[0]][r[1]][i];
				}
				min = Math.min(min, bt(k + 1, false));
				b[0] = tempb;
				r[0] = tempr;
			}
		} else {
			for (int i = 2; i < 4; i++) {
				if (length[b[0]][b[1]][i] == -1) {
					continue;
				}
				if (length[r[0]][r[1]][i] == -1) {
					min = Math.min(min, k + 1);
					continue;
				}
				if (length[b[0]][b[1]][i] == b[1] && length[r[0]][r[1]][i] == r[1]) {
					continue;
				}
				int tempb = b[1];
				int tempr = r[1];
				if (length[b[0]][b[1]][i] == length[r[0]][r[1]][i] && b[0] == r[0]) {
					if (b[1] > r[1]) {
						b[1] = length[b[0]][b[1]][i] - 2 + i;
						r[1] = length[r[0]][r[1]][i] - 3 + i;
					} else {
						b[1] = length[b[0]][b[1]][i] - 3 + i;
						r[1] = length[r[0]][r[1]][i] - 2 + i;
					}
				} else {
					b[1] = length[b[0]][b[1]][i];
					r[1] = length[r[0]][r[1]][i];
				}
				min = Math.min(min, bt(k + 1, true));
				b[1] = tempb;
				r[1] = tempr;
			}
		}
		return min;
	}
}
