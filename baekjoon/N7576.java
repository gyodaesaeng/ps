import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7576 {
	static int n, m, number;
	static boolean[][] tomato;
	static ArrayList<T> in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		tomato = new boolean[n + 2][m + 2];
		in = new ArrayList<T>();
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				String temp = st.nextToken();
				tomato[i][j] = temp.equals("0");
				if (tomato[i][j]) {
					number++;
				}
				if (temp.equals("1")) {
					in.add(new T(i, j, 0));
				}
			}
		}
	}

	static int solve() {
		Queue<T> queue = new LinkedList<T>();
		for (T t : in) {
			queue.offer(t);
		}
		T p = new T(0, 0, 0);
		while (!queue.isEmpty()) {
			p = queue.poll();
			if (tomato[p.x - 1][p.y]) {
				queue.offer(new T(p.x - 1, p.y, p.t + 1));
				tomato[p.x - 1][p.y] = false;
				number--;
			}
			if (tomato[p.x + 1][p.y]) {
				queue.offer(new T(p.x + 1, p.y, p.t + 1));
				tomato[p.x + 1][p.y] = false;
				number--;
			}
			if (tomato[p.x][p.y - 1]) {
				queue.offer(new T(p.x, p.y - 1, p.t + 1));
				tomato[p.x][p.y - 1] = false;
				number--;
			}
			if (tomato[p.x][p.y + 1]) {
				queue.offer(new T(p.x, p.y + 1, p.t + 1));
				tomato[p.x][p.y + 1] = false;
				number--;
			}
		}
		if (number == 0) {
			return p.t;
		}
		return -1;
	}
}

class T {
	int x, y, t;

	T(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}