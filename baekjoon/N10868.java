import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N10868 {
	static int n, m;
	static int[] in, out;
	static int[][] range;

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
			range[i][0] = Integer.parseInt(st.nextToken());
			range[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		Segment seg = new Segment(n);
		out = new int[m];
		for (int i = 0; i < m; i++) {
			out[i] = seg.get(1, range[i][0], range[i][1], 1, n);
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int v : out) {
			bw.write(v + "\n");
		}
		bw.flush();
	}

	static class Segment {
		int[] tree;
		int n, l;

		Segment(int n) {
			this.n = n;
			l = (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1);
			tree = new int[l];
			init(1, 1, n);
		}

		int init(int i, int s, int e) {
			if (s == e) {
				return tree[i] = in[s - 1];
			}
			return tree[i] = Math.min(init(i * 2, s, (s + e) / 2), init(i * 2 + 1, (s + e) / 2 + 1, e));
		}

		int get(int i, int s, int e, int l, int r) {
			if (s > r || e < l) {
				return Integer.MAX_VALUE;
			}
			if (s <= l && e >= r) {
				return tree[i];
			}
			return Math.min(get(i * 2, s, e, l, (l + r) / 2), get(i * 2 + 1, s, e, (l + r) / 2 + 1, r));
		}
	}
}
