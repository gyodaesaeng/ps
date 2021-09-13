import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2213 {
	static int n, ans;
	static boolean[] trace;
	static int[] w, parent;
	static int[][] memo;
	static ArrayList<Integer> vertex;
	static ArrayList<Integer>[] edges;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		edges = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(st.nextToken());
			edges[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}
	}

	static void solve() {
		memo = new int[n + 1][2];
		vertex = new ArrayList<Integer>();
		parent = new int[n + 1];
		trace = new boolean[n + 1];
		ans = dp(1, -1, 1);
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		while (!q.isEmpty()) {
			int p = q.poll();
			if (trace[p]) {
				vertex.add(p);
				for (int i : edges[p]) {
					trace[i] = false;
				}
			}
			for (int i : edges[p]) {
				if (i == parent[p]) {
					continue;
				}
				q.offer(i);
			}
		}
		Collections.sort(vertex);
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(ans + "\n");
		for (int i : vertex) {
			bw.write(i + " ");
		}
		bw.flush();
	}

	static int dp(int a, int p, int can) {
		if (memo[a][can] > 0) {
			return memo[a][can];
		}
		parent[a] = p;
		int sum = 0;
		for (int i : edges[a]) {
			if (i == p) {
				continue;
			}
			sum += dp(i, a, 1);
		}
		int temp = 0;
		if (can > 0) {
			temp = w[a];
			for (int i : edges[a]) {
				if (i == p) {
					continue;
				}
				temp += dp(i, a, 0);
			}

			if (temp > sum) {
				trace[a] = true;
				sum = temp;
			}
		}
		return memo[a][can] = sum;
	}
}
