import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N13334 {
	static int n, d;
	static P[] in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new P[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			in[i] = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		d = Integer.parseInt(br.readLine());
	}

	static int solve() {
		Arrays.sort(in);
		PriorityQueue<P> pq = new PriorityQueue<P>(new Comparator<P>() {
			public int compare(P p1, P p2) {
				return p2.e - p1.e;
			}
		});
		int ans = 0;
		for (int i = 0; i < n; i++) {
			pq.offer(in[i]);
			while (!pq.isEmpty()) {
				if (pq.peek().e <= in[i].s + d) {
					break;
				}
				pq.poll();
			}
			if (pq.size() > ans) {
				ans = pq.size();
			}
		}
		return ans;
	}

	static class P implements Comparable<P> {
		int s, e;

		P(int h, int o) {
			s = Math.min(h, o);
			e = Math.max(h, o);
		}

		@Override
		public int compareTo(P o) {
			// TODO Auto-generated method stub
			return o.s - s;
		}
	}
}
