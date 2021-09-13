import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class N17836 {
	static int n, m, t;
	static int[] sward;
	static boolean[][] map;
	static int[][] memo;
	static Deque<Point> queue;

	public static void main(String[] args) throws IOException {
		input();
		output(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new boolean[n + 2][m + 2];
		sward = new int[3];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				String str = st.nextToken();
				map[i][j] = !str.equals("1");
				if (str.equals("2")) {
					sward[0] = i;
					sward[1] = j;
				}
			}
		}
	}

	static void output(int ans) {
		if (ans > t) {
			System.out.print("Fail");
		} else {
			System.out.print(ans);
		}
	}

	static int solve() {
		memo = new int[n + 2][m + 2];
		memo[1][1] = 0;
		memo[n][m] = t + 1;
		memo[sward[0]][sward[1]] = t + 1;
		map[1][1] = false;
		bfs();
		return Math.min(memo[n][m], memo[sward[0]][sward[1]] + Math.abs(n - sward[0]) + Math.abs(m - sward[1]));
	}

	static void bfs() {
		queue = new ArrayDeque<Point>();
		queue.add(new Point(1, 1));
		while (!queue.isEmpty()) {
			Point p = queue.pop();
			if (map[p.x - 1][p.y]) {
				queue.add(new Point(p.x - 1, p.y));
				memo[p.x - 1][p.y] = memo[p.x][p.y] + 1;
				map[p.x - 1][p.y] = false;
			}
			if (map[p.x + 1][p.y]) {
				queue.add(new Point(p.x + 1, p.y));
				memo[p.x + 1][p.y] = memo[p.x][p.y] + 1;
				map[p.x + 1][p.y] = false;
			}
			if (map[p.x][p.y - 1]) {
				queue.add(new Point(p.x, p.y - 1));
				memo[p.x][p.y - 1] = memo[p.x][p.y] + 1;
				map[p.x][p.y - 1] = false;
			}
			if (map[p.x][p.y + 1]) {
				queue.add(new Point(p.x, p.y + 1));
				memo[p.x][p.y + 1] = memo[p.x][p.y] + 1;
				map[p.x][p.y + 1] = false;
			}
		}
	}
}

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}