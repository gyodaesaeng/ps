import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11725 {
	static int n;
	static int[] p;
	static ArrayList<Integer>[] in;

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
	}

	static void solve() {
		p = new int[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i : in[1]) {
			p[i] = 1;
			q.offer(i);
		}
		while (!q.isEmpty()) {
			int peek = q.poll();
			for (int i : in[peek]) {
				if (p[i] == 0) {
					p[i] = peek;
					q.offer(i);
				}
			}
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 2; i <= n; i++) {
			bw.write(p[i] + "\n");
		}
		bw.flush();
	}
}
