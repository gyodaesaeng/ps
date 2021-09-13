import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1774 {
	static int n, m;
	static int[][] in, union;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(String.format("%.2f", solve()));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		in = new int[n + m][2];
		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			in[i][0] = Integer.parseInt(st.nextToken());
			in[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static double solve() {
		union = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			union[i][0] = i;
			union[i][1] = 1;
		}
		for (int i = n; i < n + m; i++) {
			if (find(in[i][0]) != find(in[i][1])) {
				union(in[i][0], in[i][1]);
			}
		}
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (find(i) == find(j)) {
					continue;
				}
				edges.add(new Edge(i, j, length(i - 1, j - 1)));
			}
		}
		Collections.sort(edges);
		double ans = 0;
		for (Edge edge : edges) {
			if (find(edge.a) == find(edge.b)) {
				continue;
			}
			ans += edge.l;
			if (union(edge.a, edge.b) == n) {
				return ans;
			}
		}
		return ans;
	}

	static long square(long a) {
		return a * a;
	}

	static double length(int a, int b) {
		return Math.sqrt((square(in[a][0] - in[b][0]) + square(in[a][1] - in[b][1])));
	}

	static class Edge implements Comparable<Edge> {
		int a, b;
		double l;

		Edge(int a, int b, double l) {
			this.a = a;
			this.b = b;
			this.l = l;
		}

		@Override
		public int compareTo(Edge o) {
			if (l > o.l) {
				return 1;
			}
			if (l == o.l) {
				return 0;
			}
			// TODO Auto-generated method stub
			return -1;
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
}
