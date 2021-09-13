import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N15681 {
	static int n, r, q;
	static int[] query, memo;
	static int[][] in;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		in = new int[n - 1][2];
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			in[i][0] = Integer.parseInt(st.nextToken());
			in[i][1] = Integer.parseInt(st.nextToken());
		}
		query = new int[q];
		for (int i = 0; i < q; i++) {
			query[i] = Integer.parseInt(br.readLine());
		}
	}

	static void solve() {
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n - 1; i++) {
			tree[in[i][0]].add(in[i][1]);
			tree[in[i][1]].add(in[i][0]);
		}
		memo = new int[n + 1];
		dp(r, 0);
		for (int i = 0; i < q; i++) {
			query[i] = memo[query[i]];
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i : query) {
			bw.write(i + "\n");
		}
		bw.flush();
	}

	static int dp(int a, int m) {
		if (memo[a] > 0) {
			return memo[a];
		}
		int ans = 1;
		for (int i : tree[a]) {
			if (i == m) {
				continue;
			}
			ans += dp(i, a);
		}
		return memo[a] = ans;
	}
}
