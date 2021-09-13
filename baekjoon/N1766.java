import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1766 {
	static int n, m;
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
		in = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			in[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			in[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
	}

	static void solve() {
		int[] check = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j : in[i]) {
				check[j]++;
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 1; i <= n; i++) {
			if (check[i] == 0) {
				pq.offer(i);
			}
		}
		out = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int peek = pq.poll();
			for (int j : in[peek]) {
				if (--check[j] == 0) {
					pq.offer(j);
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
