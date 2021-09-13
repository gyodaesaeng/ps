import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N13344 {
	static int n, m;
	static int[] union;
	static int[][] in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve() ? "consistent" : "inconsistent");
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		in = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			in[i][0] = Integer.parseInt(st.nextToken());
			in[i][1] = st.nextToken().charAt(0) == '>' ? 1 : 0;
			in[i][2] = Integer.parseInt(st.nextToken());
		}
	}

	static boolean solve() {
		union = new int[n];
		for (int i = 0; i < n; i++) {
			union[i] = i;
		}
		ArrayList<Integer>[] edge = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			edge[i] = new ArrayList<Integer>();
		}
		int k = n;
		for (int[] arr : in) {
			if (arr[1] == 0 && find(arr[0]) != find(arr[2])) {
				union(arr[0], arr[2]);
				k--;
			}
		}
		int[] check = new int[n];
		for (int[] arr : in) {
			if (arr[1] == 1) {
				edge[find(arr[0])].add(find(arr[2]));
				check[find(arr[2])]++;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			if (check[i] == 0 && union[i] == i) {
				q.offer(i);
			}
		}
		for (int i = 0; i < k; i++) {
			if (q.isEmpty()) {
				return false;
			}
			int peek = q.poll();
			for (int j : edge[peek]) {
				if (--check[j] == 0) {
					q.offer(j);
				}
			}
		}
		return q.isEmpty();
	}

	static int find(int a) {
		if (union[a] == a) {
			return a;
		}
		return union[a] = find(union[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		union[a] = b;
	}
}
