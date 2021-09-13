import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2606 {
	static int n, m;
	static int[][] in;
	static boolean[][] conn;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		in = new int[m][2];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			in[i][0] = Integer.parseInt(st.nextToken());
			in[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static int solve() {
		conn = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			conn[in[i][0]][in[i][1]] = true;
			conn[in[i][1]][in[i][0]] = true;
		}
		boolean[] check = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		check[1] = true;
		queue.offer(1);
		int ans = 0;
		while (!queue.isEmpty()) {
			for (int i = 2; i <= n; i++) {
				if (conn[queue.peek()][i] && !check[i]) {
					queue.offer(i);
					ans++;
					check[i] = true;
				}
			}
			queue.poll();
		}
		return ans;
	}
}
