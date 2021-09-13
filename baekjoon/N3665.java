import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N3665 {
	static boolean can;
	static int n, m;
	static int[] t;
	static int[][] in;
	static ArrayList<Integer> out;
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			input();
			solve();
			output();
		}
	}

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		t = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		in = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			in[i][0] = Integer.parseInt(st.nextToken());
			in[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		boolean[][] edge = new boolean[n + 1][n + 1];
		int[] check = new int[n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				edge[t[i]][t[j]] = true;
				check[t[j]]++;
			}
		}
		for (int i = 0; i < m; i++) {
			edge[in[i][0]][in[i][1]] = !edge[in[i][0]][in[i][1]];
			edge[in[i][1]][in[i][0]] = !edge[in[i][1]][in[i][0]];
			if (edge[in[i][0]][in[i][1]]) {
				check[in[i][1]]++;
				check[in[i][0]]--;
			} else {
				check[in[i][0]]++;
				check[in[i][1]]--;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (check[i] == 0) {
				q.offer(i);
			}
		}
		out = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (q.isEmpty()) {
				can = false;
				return;
			}
			int peek = q.poll();
			for (int j = 1; j <= n; j++) {
				if (edge[peek][j]) {
					if (--check[j] == 0) {
						q.offer(j);
					}
				}
			}
			out.add(peek);
		}
		can = q.isEmpty();
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if (!can) {
			bw.write("IMPOSSIBLE");
		} else {
			for (int i : out) {
				bw.write(i + " ");
			}
		}
		bw.newLine();
		bw.flush();
	}
}