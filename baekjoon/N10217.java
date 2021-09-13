import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N10217 {
	static int n, m, k;
	static ArrayList<F>[] map;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			input();
			int out = solve();
			if (out == Integer.MAX_VALUE) {
				System.out.println("Poor KCM");
			} else {
				System.out.println(out);
			}
		}
	}

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<F>();
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int[] in = new int[4];
			for (int j = 0; j < 4; j++) {
				in[j] = Integer.parseInt(st.nextToken());
			}
			map[in[0]].add(new F(in[1], in[2], in[3]));
		}
	}

	static int solve() {
		int[][] d = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], Integer.MAX_VALUE);
		}
		PriorityQueue<F> pq = new PriorityQueue<F>();
		pq.offer(new F(1, 0, 0));
		while (!pq.isEmpty()) {
			F peek = pq.poll();
			if (peek.d <= d[peek.v][peek.c]) {
				d[peek.v][peek.c] = peek.d;
				for (F f : map[peek.v]) {
					if (peek.c + f.c <= m) {
						if (peek.d + f.d < d[f.v][peek.c + f.c]) {
							pq.offer(new F(f.v, peek.c + f.c, peek.d + f.d));
							d[f.v][peek.c + f.c] = peek.d + f.d;
						}
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= m; i++) {
			min = Math.min(min, d[n][i]);
		}
		return min;
	}

	static class F implements Comparable<F> {
		int v, c, d;

		F(int v, int c, int d) {
			this.v = v;
			this.c = c;
			this.d = d;
		}

		@Override
		public int compareTo(F o) {
			// TODO Auto-generated method stub
			return d - o.d;
		}
	}
}
