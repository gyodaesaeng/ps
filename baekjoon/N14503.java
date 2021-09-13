import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14503 {
	static int n, m, r, c, d;
	static boolean[][] map, clean;
	static int[][] check;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) + 1;
		c = Integer.parseInt(st.nextToken()) + 1;
		d = Integer.parseInt(st.nextToken());
		map = new boolean[n + 2][m + 2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = st.nextToken().equals("0");
			}
		}
	}

	static int solve() {
		clean = new boolean[n + 1][m + 1];
		int ans = 0;
		check = new int[n + 1][m + 1];
		do {
			if (!clean[r][c]) {
				ans++;
				clean[r][c] = true;
			}
		} while (step2());
		return ans;
	}

	static boolean step2() {
		if ((clean[r][c - 1] || !map[r][c - 1]) && (clean[r][c + 1] || !map[r][c + 1])
				&& (clean[r - 1][c] || !map[r - 1][c]) && (clean[r + 1][c] || !map[r + 1][c])) {
			switch (d) {
			case 0:
				r++;
				break;
			case 1:
				c--;
				break;
			case 2:
				r--;
				break;
			case 3:
				c++;
				break;
			}
			if (!map[r][c]) {
				return false;
			}
			return step2();

		}
		switch (d) {
		case 0:
			d = 3;
			if (!clean[r][c - 1] && map[r][c - 1]) {
				d = 3;
				c--;
			} else {
				return step2();
			}
			break;
		case 1:
			d = 0;
			if (!clean[r - 1][c] && map[r - 1][c]) {
				r--;
			} else {
				return step2();
			}
			break;
		case 2:
			d = 1;
			if (!clean[r][c + 1] && map[r][c + 1]) {
				c++;
			} else {
				return step2();
			}
			break;
		case 3:
			d = 2;
			if (!clean[r + 1][c] && map[r + 1][c]) {
				r++;
			} else {
				return step2();
			}
			break;
		}
		return true;
	}
}
