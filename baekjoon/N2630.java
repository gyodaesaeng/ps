import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2630 {
	static boolean[][] paper;
	static int n, w, b;

	public static void main(String[] args) throws IOException {
		input();
		w = 0;
		b = 0;
		solve(0, 0, n);
		System.out.println(w + "\n" + b);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		paper = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = st.nextToken().equals("1");
			}
		}
	}

	static int solve(int x, int y, int l) {
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if (paper[x][y] != paper[x + i][y + j]) {
					solve(x, y, l / 2);
					solve(x + l / 2, y, l / 2);
					solve(x, y + l / 2, l / 2);
					solve(x + l / 2, y + l / 2, l / 2);
					return 0;
				}
			}
		}
		if (paper[x][y]) {
			b++;
		} else {
			w++;
		}
		return 0;
	}
}
