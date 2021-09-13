import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1100 {
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new boolean[8][8];
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = str.charAt(j) == 'F';
			}
		}
	}

	static int solve() {
		int ans = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0 && map[i][j]) {
					ans++;
				}
			}
		}
		return ans;
	}
}
