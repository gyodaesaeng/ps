import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1967 {
	static int n;
	static ArrayList<Edge>[] tree;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<Edge>();
		}
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			tree[s].add(new Edge(e, l));
			tree[e].add(new Edge(s, l));
		}
	}

	static int solve() {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.offer(new Edge(1, 0));
		dist[1] = 0;
		while (!pq.isEmpty()) {
			Edge peek = pq.poll();
			if (peek.l <= dist[peek.e]) {
				dist[peek.e] = peek.l;
				for (Edge e : tree[peek.e]) {
					if (peek.l + e.l < dist[e.e]) {
						pq.offer(new Edge(e.e, peek.l + e.l));
					}
				}
			}
		}
		int maxIndex = 1;
		for (int i = 2; i <= n; i++) {
			if (dist[i] > dist[maxIndex]) {
				maxIndex = i;
			}
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.offer(new Edge(maxIndex, 0));
		dist[maxIndex] = 0;
		while (!pq.isEmpty()) {
			Edge peek = pq.poll();
			if (peek.l <= dist[peek.e]) {
				dist[peek.e] = peek.l;
				for (Edge e : tree[peek.e]) {
					if (peek.l + e.l < dist[e.e]) {
						pq.offer(new Edge(e.e, peek.l + e.l));
					}
				}
			}
		}
		int max = dist[1];
		for (int i = 2; i <= n; i++) {
			max = Math.max(max, dist[i]);
		}
		return max;
	}

	static class Edge implements Comparable<Edge> {
		int e, l;

		Edge(int e, int l) {
			this.e = e;
			this.l = l;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return l - o.l;
		}
	}
}
