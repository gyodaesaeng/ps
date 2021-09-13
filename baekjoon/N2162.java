import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2162 {
	static int n, gn, max;
	static Pair[][] in;
	static int[][] union;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(gn);
		System.out.print(max);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new Pair[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				in[i][j] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			if (in[i][0].compareTo(in[i][1]) > 0) {
				Pair temp = in[i][0];
				in[i][0] = in[i][1];
				in[i][1] = temp;
			}
		}
	}

	static void solve() {
		union = new int[n][2];
		for (int i = 0; i < n; i++) {
			union[i][0] = i;
			union[i][1] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (find(i) == find(j)) {
					continue;
				}
				if (ccw(in[i][0], in[i][1], in[j][0], in[j][1])) {
					union(i, j);
				}
			}
		}
		boolean[] check = new boolean[n];
		gn = 0;
		max = 0;
		for (int i = 0; i < n; i++) {
			if (!check[find(i)]) {
				check[find(i)] = true;
				gn++;
				max = Math.max(max, union[find(i)][1]);
			}
		}
	}

	static int find(int a) {
		if (a == union[a][0]) {
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

	static boolean ccw(Pair a, Pair b, Pair c, Pair d) {
		if (cross(a, b, c) == 0 && cross(a, b, d) == 0 && (a.compareTo(d) > 0 || b.compareTo(c) < 0)) {
			return false;
		}
		return cross(a, b, c) * cross(a, b, d) <= 0 && cross(c, d, a) * cross(c, d, b) <= 0;
	}

	static int cross(Pair a, Pair b, Pair c) {
		int ans = (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
		if (ans > 0) {
			return 1;
		}
		if (ans < 0) {
			return -1;
		}
		return 0;
	}

	static class Pair implements Comparable<Pair> {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if (x == o.x) {
				return y - o.y;
			}
			// TODO Auto-generated method stub
			return x - o.x;
		}
	}
}
