import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11437 {
	static int n, m;
	static ArrayList<Integer>[] in;
	static int[] out;
	static int[][] pairs;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			in[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			in[a].add(b);
			in[b].add(a);
		}
		m = Integer.parseInt(br.readLine());
		pairs = new int[m][2];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pairs[i][0] = Integer.parseInt(st.nextToken());
			pairs[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		Node[] nodes = new Node[n + 1];
		Queue<Node> q = new LinkedList<Node>();
		boolean[] check = new boolean[n + 1];
		nodes[1] = new Node();
		q.offer(nodes[1]);
		check[1] = true;
		while (!q.isEmpty()) {
			Node peek = q.poll();
			for (int i : in[peek.n]) {
				if (!check[i]) {
					nodes[i] = new Node(i, peek);
					q.offer(nodes[i]);
					check[i] = true;
				}
			}
		}
		out = new int[m];
		for (int i = 0; i < m; i++) {
			Node parent = nodes[pairs[i][0]].sameParent(nodes[pairs[i][1]]);
			out[i] = parent.n;
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i : out) {
			bw.write(i + "\n");
		}
		bw.flush();
	}

	static class Node {
		int n, h;
		ArrayList<Node> parents;

		Node(int n, Node m) {
			this.n = n;
			parents = new ArrayList<Node>();
			parents.add(m);
			h = m.h + 1;
			int logh = log(h);
			for (int i = 0; i < logh; i++) {
				parents.add(parents.get(i).parents.get(i));
			}
		}

		Node() {
			n = 1;
			h = 0;
		}

		Node getParents(int i) {
			if (i == h) {
				return this;
			}
			return parents.get(log(h - i)).getParents(i);
		}

		Node sameParent(Node a) {
			Node b = this;
			if (a.h > b.h) {
				a = a.getParents(b.h);
			} else {
				b = b.getParents(a.h);
			}
			if (a.n == b.n) {
				return a;
			}
			if (a.parents.get(0) == b.parents.get(0)) {
				return a.parents.get(0);
			}
			for (int j = 1; j <= log(a.h); j++) {
				if (a.parents.get(j).n == b.parents.get(j).n) {
					return b.parents.get(j - 1).sameParent(a.parents.get(j - 1));
				}
			}
			return a.parents.get(log(a.h)).sameParent(b);
		}
	}

	static int log(int n) {
		return (int) (Math.log(n) / Math.log(2));
	}
}
