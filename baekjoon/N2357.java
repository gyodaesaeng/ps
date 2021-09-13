import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2357 {
	static int n, m;
	static int[] in;
	static int[][] range, out;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		in = new int[n];
		for (int i = 0; i < n; i++) {
			in[i] = Integer.parseInt(br.readLine());
		}
		range = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			range[i][0] = Integer.parseInt(st.nextToken()) - 1;
			range[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}
	}

	static void solve() {
		out = new int[m][2];
		Segment seg = new Segment(n, in);
		for (int i = 0; i < m; i++) {
			out[i][0] = seg.getMin(1, 0, n - 1, range[i][0], range[i][1]);
			out[i][1] = seg.getMax(1, 0, n - 1, range[i][0], range[i][1]);
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < m; i++) {
			bw.write(out[i][0] + " " + out[i][1] + "\n");
		}
		bw.flush();
	}

	static class Segment {
		int n, h;
		int[] in, min, max;

		Segment(int n, int[] in) {
			this.n = n;
			this.in = in;
			h = (int) Math.ceil(Math.log(n) / Math.log(2));
			min = new int[(int) Math.pow(2, h + 1)];
			max = new int[(int) Math.pow(2, h + 1)];
			initMin(1, 0, n - 1);
			initMax(1, 0, n - 1);
		}

		int initMin(int node, int s, int e) {
			if (s == e) {
				return min[node] = in[s];
			}
			return min[node] = Math.min(initMin(node * 2, s, (s + e) / 2), initMin(node * 2 + 1, (s + e) / 2 + 1, e));
		}

		int initMax(int node, int s, int e) {
			if (s == e) {
				return max[node] = in[s];
			}
			return max[node] = Math.max(initMax(node * 2, s, (s + e) / 2), initMax(node * 2 + 1, (s + e) / 2 + 1, e));
		}

		int getMin(int node, int s, int e, int l, int r) {
			if (l > e || r < s) {
				return Integer.MAX_VALUE;
			}
			if (l <= s && e <= r) {
				return min[node];
			}
			return Math.min(getMin(node * 2, s, (s + e) / 2, l, r), getMin(node * 2 + 1, (s + e) / 2 + 1, e, l, r));
		}

		int getMax(int node, int s, int e, int l, int r) {
			if (l > e || r < s) {
				return Integer.MIN_VALUE;
			}
			if (l <= s && e <= r) {
				return max[node];
			}
			return Math.max(getMax(node * 2, s, (s + e) / 2, l, r), getMax(node * 2 + 1, (s + e) / 2 + 1, e, l, r));
		}
	}
}
