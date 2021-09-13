import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11404 {
	static final int INF = 10000000;
	static int n, m;
	static int[][] d;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		d = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], INF);
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			d[a][b] = Math.min(d[a][b], c);
		}
	}

	static void solve() {
		for (int i = 1; i <= n; i++) {
			d[i][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					d[j][k] = Math.min(d[j][k], d[j][i] + d[i][k]);
				}
			}
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] < INF) {
					bw.write(d[i][j] + " ");
				} else {
					bw.write("0 ");
				}
			}
			bw.newLine();
		}
		bw.flush();
	}
}
