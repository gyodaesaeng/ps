import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2252 {
	static int n, m;
	static int[] inDegree;
	static ArrayList<Integer> out;
	static ArrayList<Integer>[] in;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		inDegree = new int[n + 1];
		in = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			in[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			inDegree[b]++;
			in[a].add(b);
		}
	}

	static void solve() {
		out = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int peek = q.poll();
			for (int i : in[peek]) {
				if (--inDegree[i] == 0) {
					q.offer(i);
				}
			}
			out.add(peek);
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i : out) {
			bw.write(i + " ");
		}
		bw.flush();
	}
}
