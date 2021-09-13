import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1520 {
	static int m, n;
	static int[][] map;
	static int[][] way;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(getWay(m - 1, n - 1));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		way = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				way[i][j] = -1;
			}
		}
		way[0][0] = 1;
	}

	static int getWay(int y, int x) {
		if (way[y][x] > -1) {
			return way[y][x];
		}
		way[y][x]++;
		if (y > 0) {
			if (map[y - 1][x] > map[y][x]) {
				way[y][x] += getWay(y - 1, x);
			}
		}
		if (x > 0) {
			if (map[y][x - 1] > map[y][x]) {
				way[y][x] += getWay(y, x - 1);
			}
		}
		if (y < m - 1) {
			if (map[y + 1][x] > map[y][x]) {
				way[y][x] += getWay(y + 1, x);
			}
		}
		if (x < n - 1) {
			if (map[y][x + 1] > map[y][x]) {
				way[y][x] += getWay(y, x + 1);
			}
		}
		return way[y][x];
	}
}
