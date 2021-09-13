import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1956 {
	static final int INF = 4000000;
	static int v, e;
	static int[][] d;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		d = new int[v + 1][v + 1];
		for (int i = 1; i <= v; i++) {
			Arrays.fill(d[i], INF);
			d[i][i] = 0;
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int[] in = new int[3];
			for (int j = 0; j < 3; j++) {
				in[j] = Integer.parseInt(st.nextToken());
			}
			d[in[0]][in[1]] = Math.min(d[in[0]][in[1]], in[2]);
		}
	}

	static int solve() {
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				for (int k = 1; k <= v; k++) {
					d[j][k] = Math.min(d[j][k], d[j][i] + d[i][k]);
				}
			}
		}
		int min = INF * 2;
		for (int i = 1; i < v; i++) {
			for (int j = i + 1; j <= v; j++) {
				if (d[i][j] < INF && d[j][i] < INF) {
					min = Math.min(min, d[i][j] + d[j][i]);
				}
			}
		}
		return min < INF * 2 ? min : -1;
	}
}
