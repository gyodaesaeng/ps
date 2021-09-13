import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N4386 {
	static int n;
	static int[][] union;
	static double[][] in;
	static Edge[] edges;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new double[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			in[i][0] = Double.parseDouble(st.nextToken());
			in[i][1] = Double.parseDouble(st.nextToken());
		}
	}

	static double solve() {
		edges = new Edge[n * (n - 1) / 2];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				edges[index++] = new Edge(i, j, Math.sqrt(square(in[i][0] - in[j][0]) + square(in[i][1] - in[j][1])));
			}
		}
		Arrays.sort(edges);
		union = new int[index][2];
		for (int i = 0; i < index; i++) {
			union[i][0] = i;
			union[i][1] = 1;
		}
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

	static double square(double a) {
		return a * a;
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
			return -1;
		}
	}
}
