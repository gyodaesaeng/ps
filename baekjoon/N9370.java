import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N9370 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			ArrayList<Node>[] map = new ArrayList[n + 1];
			for (int j = 1; j <= n; j++) {
				map[j] = new ArrayList<Node>();
			}
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				map[a].add(new Node(b, d));
				map[b].add(new Node(a, d));
			}
			int[] can = new int[t];
			for (int j = 0; j < t; j++) {
				can[j] = Integer.parseInt(br.readLine());
			}
			int[] sl = di(s, n, map);
			int[] hl = di(h, n, map);
			int[] gl = di(g, n, map);
			ArrayList<Integer> ans = new ArrayList<Integer>();
			for (int x : can) {
				if (sl[x] == Math.min(sl[g] + hl[g] + hl[x], sl[h] + gl[h] + gl[x])) {
					ans.add(x);
				}
			}
			Collections.sort(ans);
			for (int x : ans) {
				bw.write(x + " ");
			}
			bw.write("\n");
			bw.flush();
		}
	}

	static int[] di(int s, int n, ArrayList<Node>[] map) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int[] l = new int[n + 1];
		Arrays.fill(l, Integer.MAX_VALUE);
		pq.add(new Node(s, 0));
		while (!pq.isEmpty()) {
			Node peek = pq.poll();
			if (peek.l <= l[peek.e]) {
				l[peek.e] = peek.l;
				for (Node node : map[peek.e]) {
					if (node.l + peek.l <= l[node.e]) {
						l[node.e] = peek.l + node.l;
						pq.add(new Node(node.e, peek.l + node.l));
					}
				}
			}
		}
		return l;
	}

	static class Node implements Comparable<Node> {
		int e, l;

		Node(int e, int l) {
			this.e = e;
			this.l = l;
		}

		@Override
		public int compareTo(Node o) {
			if (l > o.l) {
				return 1;
			}
			if (l == o.l) {
				return 0;
			}
			// TODO Auto-generated method stub
			return -1;
		}
	}
}
