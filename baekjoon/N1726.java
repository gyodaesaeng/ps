import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1726 {
	static boolean[][] map;
	static int[] s, e;
	static int m, n;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new boolean[m + 2][n + 2];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = st.nextToken().equals("0");
			}
		}
		st = new StringTokenizer(br.readLine());
		s = new int[4];
		for (int i = 0; i < 3; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		e = new int[3];
		for (int i = 0; i < 3; i++) {
			e[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		boolean[][][] check = new boolean[m + 2][n + 2][5];
		Queue<Robot> queue = new LinkedList<Robot>();
		queue.offer(new Robot(s[0], s[1], s[2], 0));
		check[s[0]][s[1]][s[2]] = true;
		Robot end = new Robot(e[0], e[1], e[2], 0);
		Robot peek = queue.peek();
		while (!peek.equal(end)) {
			switch (peek.d) {
			case 1:
				if (!check[peek.x][peek.y][3]) {
					check[peek.x][peek.y][3] = true;
					queue.offer(new Robot(peek.x, peek.y, 3, peek.t + 1));
				}
				if (!check[peek.x][peek.y][4]) {
					check[peek.x][peek.y][4] = true;
					queue.offer(new Robot(peek.x, peek.y, 4, peek.t + 1));
				}
				for (int i = peek.y + 1; map[peek.x][i] && i - peek.y < 4; i++) {
					if (!check[peek.x][i][1]) {
						check[peek.x][i][1] = true;
						queue.offer(new Robot(peek.x, i, 1, peek.t + 1));
					}
				}
				break;
			case 2:
				if (!check[peek.x][peek.y][3]) {
					check[peek.x][peek.y][3] = true;
					queue.offer(new Robot(peek.x, peek.y, 3, peek.t + 1));
				}
				if (!check[peek.x][peek.y][4]) {
					check[peek.x][peek.y][4] = true;
					queue.offer(new Robot(peek.x, peek.y, 4, peek.t + 1));
				}
				for (int i = peek.y - 1; map[peek.x][i] && peek.y - i < 4; i--) {
					if (!check[peek.x][i][2]) {
						check[peek.x][i][2] = true;
						queue.offer(new Robot(peek.x, i, 2, peek.t + 1));
					}
				}
				break;
			case 3:
				if (!check[peek.x][peek.y][1]) {
					check[peek.x][peek.y][1] = true;
					queue.offer(new Robot(peek.x, peek.y, 1, peek.t + 1));
				}
				if (!check[peek.x][peek.y][2]) {
					check[peek.x][peek.y][2] = true;
					queue.offer(new Robot(peek.x, peek.y, 2, peek.t + 1));
				}
				for (int i = peek.x + 1; map[i][peek.y] && i - peek.x < 4; i++) {
					if (!check[i][peek.y][3]) {
						check[i][peek.y][3] = true;
						queue.offer(new Robot(i, peek.y, 3, peek.t + 1));
					}
				}
				break;
			case 4:
				if (!check[peek.x][peek.y][1]) {
					check[peek.x][peek.y][1] = true;
					queue.offer(new Robot(peek.x, peek.y, 1, peek.t + 1));
				}
				if (!check[peek.x][peek.y][2]) {
					check[peek.x][peek.y][2] = true;
					queue.offer(new Robot(peek.x, peek.y, 2, peek.t + 1));
				}
				for (int i = peek.x - 1; map[i][peek.y] && peek.x - i < 4; i--) {
					if (!check[i][peek.y][4]) {
						check[i][peek.y][4] = true;
						queue.offer(new Robot(i, peek.y, 4, peek.t + 1));
					}
				}
				break;
			}
			queue.poll();
			peek = queue.peek();
		}
		System.out.print(peek.t);
	}
}

class Robot {
	int x, y, d, t;

	Robot(int x, int y, int d, int t) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.t = t;
	}

	boolean equal(Robot r) {
		return r.x == x && r.y == y && r.d == d;
	}
}