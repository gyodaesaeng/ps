import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1012 {
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			map = new boolean[m + 2][n + 2];
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken()) + 1][Integer.parseInt(st.nextToken()) + 1] = true;
			}
			int ans = 0;
			for (int j = 1; j < m + 2; j++) {
				for (int l = 1; l < n + 2; l++) {
					if (map[j][l]) {
						ans++;
						check(j, l);
					}
				}
			}
			System.out.println(ans);
		}
	}

	static void check(int x, int y) {
		if (map[x][y]) {
			map[x][y] = false;
			check(x - 1, y);
			check(x + 1, y);
			check(x, y - 1);
			check(x, y + 1);
		}
	}
}
