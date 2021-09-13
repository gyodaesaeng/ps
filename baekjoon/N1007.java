import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1007 {
	static int n;
	static int[][] map;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			input();
			System.out.println(Math.sqrt(bt(0, n / 2, 0, 0)));
		}
	}

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static long bt(int i, int plus, long x, long y) {
		if (i == n) {
			return x * x + y * y;
		}
		if (plus == 0) {
			return bt(i + 1, plus, x - map[i][0], y - map[i][1]);
		}
		if (plus == n - i) {
			return bt(i + 1, plus - 1, x + map[i][0], y + map[i][1]);
		}
		return Math.min(bt(i + 1, plus, x - map[i][0], y - map[i][1]),
				bt(i + 1, plus - 1, x + map[i][0], y + map[i][1]));
	}
}