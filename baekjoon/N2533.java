import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N2533 {
	static int n;
	static ArrayList<Integer>[] tree;
	static int[][] memo;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
	}

	static int solve() {
		memo = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			memo[i][0] = memo[i][1] = -1;
		}
		return Math.min(dp(1, 0, 0), n - dp(1, 0, 0));
	}

	static int dp(int a, int parent, int now) {
		if (memo[a][now] > -1) {
			return memo[a][now];
		}
		int ans = 1;
		for (int i : tree[a]) {
			if (i == parent) {
				continue;
			}
			ans += dp(i, a, 0);
		}
		if (now == 0) {
			int temp = 0;
			for (int i : tree[a]) {
				if (i == parent) {
					continue;
				}
				temp += dp(i, a, 1);
			}
			ans = Math.min(ans, temp);
		}
		return memo[a][now] = ans;
	}
}
