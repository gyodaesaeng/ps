import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2178 {
	static boolean[][] map;
	static int n, m;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n + 2][m + 2];
		for (int i = 1; i <= n; i++) {
			char[] chars = br.readLine().toCharArray();
			int j = 1;
			for (char c : chars) {
				map[i][j++] = c == '1';
			}
		}
	}

	static int solve() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(1, 1, 1));
		map[1][1] = false;
		while (true) {
			Pos p = q.peek();
			if (p.x == n && p.y == m) {
				return p.t;
			}
			if (map[p.x - 1][p.y]) {
				map[p.x - 1][p.y] = false;
				q.offer(new Pos(p.x - 1, p.y, p.t + 1));
			}
			if (map[p.x + 1][p.y]) {
				map[p.x + 1][p.y] = false;
				q.offer(new Pos(p.x + 1, p.y, p.t + 1));
			}
			if (map[p.x][p.y - 1]) {
				map[p.x][p.y - 1] = false;
				q.offer(new Pos(p.x, p.y - 1, p.t + 1));
			}
			if (map[p.x][p.y + 1]) {
				map[p.x][p.y + 1] = false;
				q.offer(new Pos(p.x, p.y + 1, p.t + 1));
			}
			q.poll();
		}
	}
}

class Pos {
	int x, y, t;

	Pos(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}