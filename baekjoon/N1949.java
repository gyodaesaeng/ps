import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N1949 {
	static int n;
	static int[] value;
	static ArrayList<Integer>[] tree;
	static int[][] memo;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		value = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
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
		return dp(1, 0, 1);
	}

	static int dp(int a, int p, int can) {
		if (memo[a][can] > -1) {
			return memo[a][can];
		}
		int ans = 0;
		for (int i : tree[a]) {
			if (i == p) {
				continue;
			}
			ans += dp(i, a, 1);
		}
		if (can > 0) {
			int temp = value[a];
			for (int i : tree[a]) {
				if (i == p) {
					continue;
				}
				temp += dp(i, a, 0);
			}
			ans = Math.max(ans, temp);
		}
		return memo[a][can] = ans;
	}
}
