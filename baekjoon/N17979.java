import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N17979 {
	static int m, n;
	static int[] v;
	static M[] in;
	static int[] memo;
	static ArrayList<Integer> index;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		v = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			v[i] = Integer.parseInt(br.readLine());
		}
		in = new M[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			in[i] = new M(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
	}

	static int solve() {
		Arrays.sort(in);
		memo = new int[15000];
		index = new ArrayList<Integer>();
		for (int i = 0; i <= in[0].s; i++) {
			index.add(0);
		}
		for (int i = 1; i < n; i++) {
			for (int j = in[i - 1].s + 1; j <= in[i].s; j++) {
				index.add(i);
			}
		}
		return dp(0);
	}

	static int dp(int s) {
		if (s >= index.size()) {
			return 0;
		}
		if (memo[s] > 0) {
			return memo[s];
		}
		int max = 0;
		for (int j = index.get(s); j < n; j++) {
			if (in[j].s != in[j].e) {
				max = Math.max(max, in[j].p + dp(in[j].e));
			}
		}
		return memo[s] = max;
	}

	static class M implements Comparable<M> {
		int s, e, p;

		M(int s, int e, int t) {
			this.s = s;
			this.e = e;
			p = (e - s) * v[t];
		}

		@Override
		public int compareTo(M o) {
			if (s > o.s) {
				return 1;
			}
			if (s == o.s && e < o.e) {
				return 1;
			}
			// TODO Auto-generated method stub
			return -1;
		}
	}
}
