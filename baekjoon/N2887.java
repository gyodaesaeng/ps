import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2887 {
	static int n;
	static int[][] in, union;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				in[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static long solve() {
		Co[][] co = new Co[3][n];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < n; j++) {
				co[i][j] = new Co(j, in[j][i]);
			}
		}
		for (int i = 0; i < 3; i++) {
			Arrays.sort(co[i]);
		}
		Edge[] edges = new Edge[3 * (n - 1)];
		int index = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j < n; j++) {
				edges[index++] = new Edge(co[i][j].index, co[i][j - 1].index, co[i][j].value - co[i][j - 1].value);
			}
		}
		Arrays.sort(edges);
		union = new int[n][2];
		for (int i = 0; i < n; i++) {
			union[i][0] = i;
			union[i][1] = 1;
		}
		long ans = 0;
		for (Edge edge : edges) {
			int temp = union(edge.a, edge.b);
			if (temp == 0) {
				continue;
			}
			ans += edge.l;
			if (temp == n) {
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
		if (a == b) {
			return 0;
		}
		union[a][0] = b;
		return union[b][1] += union[a][1];
	}

	static class Co implements Comparable<Co> {
		int index, value;

		Co(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Co o) {
			// TODO Auto-generated method stub
			return value - o.value;
		}
	}

	static class Edge implements Comparable<Edge> {
		int a, b, l;

		Edge(int a, int b, int l) {
			this.a = a;
			this.b = b;
			this.l = l;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return l - o.l;
		}
	}
}
