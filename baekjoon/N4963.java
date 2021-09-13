import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4963 {
	static int w, h;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}
			map = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = st.nextToken().equals("1");
				}
			}
			int number = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j]) {
						number++;
						find(i, j);
					}
				}
			}
			System.out.println(number);
		}
	}

	static void find(int y, int x) {
		if (y < 0 || y == h || x < 0 || x == w) {
			return;
		}
		if (map[y][x]) {
			map[y][x] = false;
			for (int i = y - 1; i <= y + 1; i++) {
				for (int j = x - 1; j <= x + 1; j++) {
					if (i == y && j == x) {
						continue;
					}
					find(i, j);
				}
			}
		}
	}
}
