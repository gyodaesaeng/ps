import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N17143 {
	static int r, c, m;
	static Shark[][] map;
	static Shark[] Sharks;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Sharks = new Shark[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int[] temp = new int[5];
			for (int j = 0; j < 5; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}
			Sharks[i] = new Shark(temp[0] - 1, temp[1] - 1, temp[2], temp[3], temp[4]);
		}
		Arrays.sort(Sharks);
	}

	static void solve() {
		int ans = 0;
		map = new Shark[r][c];
		for (Shark i : Sharks) {
			map[i.r][i.c] = i;
		}
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (map[j][i] != null) {
					if (map[j][i].z > 0) {
						ans += map[j][i].z;
						map[j][i].z = 0;
						break;
					}
				}
			}
			Shark[][] tempMap = new Shark[r][c];
			for (Shark j : Sharks) {
				if (j.z == 0) {
					continue;
				}
				int a = j.r;
				int b = j.c;
				switch (j.d) {
				case 4:
					b -= j.s;
					while (b < 0 || b >= c) {
						if (b < 0) {
							b = -b;
							j.d = 3;
						} else {
							b = 2 * (c - 1) - b;
							j.d = 4;
						}
					}
					break;
				case 3:
					b += j.s;
					while (b < 0 || b >= c) {
						if (b < 0) {
							b = -b;
							j.d = 3;
						} else {
							b = 2 * (c - 1) - b;
							j.d = 4;
						}
					}
					break;
				case 2:
					a += j.s;
					while (a < 0 || a >= r) {
						if (a < 0) {
							a = -a;
							j.d = 2;
						} else {
							a = 2 * (r - 1) - a;
							j.d = 1;
						}
					}
					break;
				case 1:
					a -= j.s;
					while (a < 0 || a >= r) {
						if (a < 0) {
							a = -a;
							j.d = 2;
						} else {
							a = 2 * (r - 1) - a;
							j.d = 1;
						}
					}
					break;
				}
				if (tempMap[a][b] != null) {
					tempMap[a][b].z = 0;
				}
				j.r = a;
				j.c = b;
				tempMap[a][b] = j;
			}
			map = tempMap;
		}
		System.out.println(ans);
	}
}

class Shark implements Comparable<Shark> {
	int r, c, s, d, z;

	Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}

	@Override
	public int compareTo(Shark o) {
		if (this.z > o.z) {
			return 1;
		} else {
			return -1;
		}
	}
}
