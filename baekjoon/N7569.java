import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7569 {
	static int n, m, h, number;
	static boolean[][][] tomato;
	static ArrayList<T2> in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		tomato = new boolean[n + 2][m + 2][h + 2];
		in = new ArrayList<T2>();
		for (int k = 1; k <= h; k++) {
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= m; j++) {
					String temp = st.nextToken();
					tomato[i][j][k] = temp.equals("0");
					if (tomato[i][j][k]) {
						number++;
					}
					if (temp.equals("1")) {
						in.add(new T2(i, j, k, 0));
					}
				}
			}
		}
	}

	static int solve() {
		Queue<T2> queue = new LinkedList<T2>();
		for (T2 t : in) {
			queue.offer(t);
		}
		T2 p = new T2(0, 0, 0, 0);
		while (!queue.isEmpty()) {
			p = queue.poll();
			if (tomato[p.x - 1][p.y][p.z]) {
				queue.offer(new T2(p.x - 1, p.y, p.z, p.t + 1));
				tomato[p.x - 1][p.y][p.z] = false;
				number--;
			}
			if (tomato[p.x + 1][p.y][p.z]) {
				queue.offer(new T2(p.x + 1, p.y, p.z, p.t + 1));
				tomato[p.x + 1][p.y][p.z] = false;
				number--;
			}
			if (tomato[p.x][p.y - 1][p.z]) {
				queue.offer(new T2(p.x, p.y - 1, p.z, p.t + 1));
				tomato[p.x][p.y - 1][p.z] = false;
				number--;
			}
			if (tomato[p.x][p.y + 1][p.z]) {
				queue.offer(new T2(p.x, p.y + 1, p.z, p.t + 1));
				tomato[p.x][p.y + 1][p.z] = false;
				number--;
			}
			if (tomato[p.x][p.y][p.z - 1]) {
				queue.offer(new T2(p.x, p.y, p.z - 1, p.t + 1));
				tomato[p.x][p.y][p.z - 1] = false;
				number--;
			}
			if (tomato[p.x][p.y][p.z + 1]) {
				queue.offer(new T2(p.x, p.y, p.z + 1, p.t + 1));
				tomato[p.x][p.y][p.z + 1] = false;
				number--;
			}
		}
		if (number == 0) {
			return p.t;
		}
		return -1;
	}
}

class T2 {
	int x, y, z, t;

	T2(int x, int y, int z, int t) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.t = t;
	}
}
