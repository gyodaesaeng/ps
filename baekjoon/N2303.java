import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2303 {
	static int n;
	static int[][] in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new int[n][5];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				in[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int solve() {
		int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			for (int x = 0; x < 3; x++) {
				for (int y = x + 1; y < 4; y++) {
					for (int z = y + 1; z < 5; z++) {
						if (sum[i] < (in[i][x] + in[i][y] + in[i][z]) % 10) {
							sum[i] = (in[i][x] + in[i][y] + in[i][z]) % 10;
						}
					}
				}
			}
		}
		int max = 0;
		for (int i = 1; i < n; i++) {
			if (sum[max] <= sum[i]) {
				max = i;
			}
		}
		return max + 1;
	}
}
