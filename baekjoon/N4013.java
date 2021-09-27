import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N4013 {
	static int n, m, s, number;
	static boolean[] res, sRes;
	static int[] cash, scc, sCash, memo;
	static ArrayList<Integer>[] graph, sccList;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		cash = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			cash[i] = Integer.parseInt(br.readLine());
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		res = new boolean[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < p; i++) {
			res[Integer.parseInt(st.nextToken())] = true;
		}
	}

	static int solve() {
		scc();
		memo = new int[number];
		Arrays.fill(memo, -1);
		return dp(scc[s]);
	}

	static void scc() {
		ArrayList<Integer>[] rGraph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			rGraph[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= n; i++) {
			for (int j : graph[i]) {
				rGraph[j].add(i);
			}
		}
		ArrayList<Integer> dfs = new ArrayList<Integer>();
		boolean[] check = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (!check[i]) {
				dfs(i, check, dfs, graph);
			}
		}
		scc = new int[n + 1];
		sRes = new boolean[n + 1];
		sCash = new int[n + 1];
		sccList = new ArrayList[n + 1];
		check = new boolean[n + 1];
		number = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (!check[dfs.get(i)]) {
				sccList[number] = new ArrayList<Integer>();
				dfs(dfs.get(i), check, sccList[number], rGraph);
				for (int j : sccList[number]) {
					scc[j] = number;
					sCash[number] += cash[j];
					sRes[number] = sRes[number] | res[j];
				}
				number++;
			}
		}
	}

	static int dp(int a) {
		if (memo[a] >= 0) {
			return memo[a];
		}
		int max = 0;
		for (int i : sccList[a]) {
			for (int j : graph[i]) {
				if (a != scc[j]) {
					max = Math.max(max, dp(scc[j]));
				}
			}
		}
		if (sRes[a] || max > 0) {
			max += sCash[a];
		}
		return memo[a] = max;
	}

	static void dfs(int a, boolean[] check, ArrayList<Integer> dfs, ArrayList<Integer>[] g) {
		check[a] = true;
		for (int i : g[a]) {
			if (!check[i]) {
				dfs(i, check, dfs, g);
			}
		}
		dfs.add(a);
	}
}
