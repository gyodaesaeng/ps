import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2206 {
	static int n, m;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n + 4][m + 4];
		for (int i = 2; i < n + 2; i++) {
			char[] str = br.readLine().toCharArray();
			int j = 2;
			for (char c : str) {
				map[i][j++] = c == '0';
			}
		}
	}

	static int solve() {
		boolean[][][] check = new boolean[n + 4][m + 4][2];
		Queue<P> queue = new LinkedList<P>();
		queue.offer(new P(2, 2, 1, true));
		while (!queue.isEmpty()) {
			P p = queue.poll();
			if (p.x == n + 1 && p.y == m + 1) {
				return p.t;
			}
			if (!check[p.x + 1][p.y][!map[p.x + 1][p.y] | !p.wall ? 1 : 0] && map[p.x + 1][p.y] | p.wall) {
				check[p.x + 1][p.y][!map[p.x + 1][p.y] | !p.wall ? 1 : 0] = true;
				queue.offer(new P(p.x + 1, p.y, p.t + 1, !(map[p.x + 1][p.y] ^ p.wall)));
			}
			if (!check[p.x - 1][p.y][!map[p.x - 1][p.y] | !p.wall ? 1 : 0] && map[p.x - 1][p.y] | p.wall) {
				check[p.x - 1][p.y][!map[p.x - 1][p.y] | !p.wall ? 1 : 0] = true;
				queue.offer(new P(p.x - 1, p.y, p.t + 1, !(map[p.x - 1][p.y] ^ p.wall)));
			}
			if (!check[p.x][p.y + 1][!map[p.x][p.y + 1] | !p.wall ? 1 : 0] && map[p.x][p.y + 1] | p.wall) {
				check[p.x][p.y + 1][!map[p.x][p.y + 1] | !p.wall ? 1 : 0] = true;
				queue.offer(new P(p.x, p.y + 1, p.t + 1, !(map[p.x][p.y + 1] ^ p.wall)));
			}
			if (!check[p.x][p.y - 1][!map[p.x][p.y - 1] | !p.wall ? 1 : 0] && map[p.x][p.y - 1] | p.wall) {
				check[p.x][p.y - 1][!map[p.x][p.y - 1] | !p.wall ? 1 : 0] = true;
				queue.offer(new P(p.x, p.y - 1, p.t + 1, !(map[p.x][p.y - 1] ^ p.wall)));
			}
		}
		return -1;
	}
}

class P {
	int x, y, t;
	boolean wall;

	P(int x, int y, int t, boolean wall) {
		this.x = x;
		this.y = y;
		this.t = t;
		this.wall = wall;
	}
}
