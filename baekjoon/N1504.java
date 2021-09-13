import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1504 {
	static int n, e;
	static int[] s;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = Math.min(map[a][b], c);
		}
		st = new StringTokenizer(br.readLine());
		s = new int[3];
		s[0] = 1;
		s[1] = Integer.parseInt(st.nextToken());
		s[2] = Integer.parseInt(st.nextToken());
	}

	static void solve() {
		int[][] length = new int[3][n + 1];
		for (int i = 0; i < 3; i++) {
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			pq.offer(new Edge(s[i], 0));
			Arrays.fill(length[i], Integer.MAX_VALUE);
			while (!pq.isEmpty()) {
				Edge peek = pq.poll();
				if (peek.l <= length[i][peek.e]) {
					length[i][peek.e] = peek.l;
					for (int j = 1; j <= n; j++) {
						if (map[j][peek.e] < Integer.MAX_VALUE && peek.l + map[j][peek.e] <= length[i][j]) {
							pq.offer(new Edge(j, peek.l + map[j][peek.e]));
						}
					}
				}
			}
		}
		long ans = length[1][s[2]]
				+ Math.min((long) length[0][s[1]] + length[2][n], (long) length[0][s[2]] + length[1][n]);
		if (ans < Integer.MAX_VALUE) {
			System.out.print(ans);
		} else {
			System.out.print(-1);
		}
	}

	static class Edge implements Comparable<Edge> {
		int e, l;

		Edge(int e, int l) {
			this.e = e;
			this.l = l;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.l > o.l) {
				return 1;
			}
			if (this.l == o.l) {
				return 0;
			}
			// TODO Auto-generated method stub
			return -1;
		}
	}
}
