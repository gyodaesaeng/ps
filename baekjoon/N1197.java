import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1197 {
	static int v, e;
	static int[][] union;
	static Edge[] graph;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		graph = new Edge[e];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int[] in = new int[3];
			for (int j = 0; j < 3; j++) {
				in[j] = Integer.parseInt(st.nextToken());
			}
			graph[i] = new Edge(in[0], in[1], in[2]);
		}
	}

	static long solve() {
		Arrays.sort(graph);
		union = new int[v + 1][2];
		for (int i = 1; i <= v; i++) {
			union[i][0] = i;
			union[i][1] = 1;
		}
		long ans = 0;
		for (Edge edge : graph) {
			if (find(edge.a) == find(edge.b)) {
				continue;
			}
			ans += edge.c;
			if (union(edge.a, edge.b) == v) {
				return ans;
			}
		}
		return ans;
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
		int a, b, c;

		Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return c - o.c;
		}
	}
}
