import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N3584 {
	static int n, root, n1, n2;
	static int[] in, depth;
	static ArrayList<Integer>[] child, parent;
	static BufferedReader br;

	public static void main(String[] main) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			input();
			System.out.println(solve());
		}
	}

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());

		in = new int[n + 1];
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			in[b] = a;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		n1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());
	}

	static int solve() {
		depth = new int[n + 1];
		Arrays.fill(depth, -1);
		child = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			child[i] = new ArrayList<Integer>();
		}
		root = 0;
		for (int i = 1; i <= n; i++) {
			if (in[i] == 0) {
				root = i;
			} else {
				child[in[i]].add(i);
			}
		}
		depth[root] = 0;
		parent = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = new ArrayList<Integer>();
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(root);
		while (!q.isEmpty()) {
			int peek = q.poll();
			for (int i : child[peek]) {
				q.offer(i);
				depth[i] = depth[peek] + 1;
				parent[i].add(peek);
				for (int j = 0; parent[parent[i].get(j)].size() > j; j++) {
					parent[i].add(parent[parent[i].get(j)].get(j));
				}
			}
		}
		if (depth[n1] > depth[n2]) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		n2 = getParent(n2, depth[n1]);
		if (n1 == n2) {
			return n1;
		}
		while (true) {
			for (int i = 0; i < parent[n1].size(); i++) {
				if (parent[n1].get(i) == parent[n2].get(i)) {
					if (i == 0) {
						return parent[n1].get(0);
					}
					n1 = parent[n1].get(i - 1);
					n2 = parent[n2].get(i - 1);
					i = -1;
				}
			}
			if (parent[n1].size() == 0) {
				return n1;
			}
			n1 = parent[n1].get(parent[n1].size() - 1);
			n2 = parent[n2].get(parent[n2].size() - 1);
		}
	}

	static int getParent(int node, int d) {
		while (depth[node] > d) {
			node = parent[node].get((int) (Math.log(depth[node] - d) / Math.log(2)));
		}
		return node;
	}
}
