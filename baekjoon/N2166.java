import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2166 {
	static int n;
	static int[][] in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new int[n + 1][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			in[i][0] = Integer.parseInt(st.nextToken());
			in[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static String solve() {
		long ans = 0;
		in[n][0] = in[0][0];
		in[n][1] = in[0][1];
		for (int i = 0; i < n; i++) {
			ans += (long) in[i][0] * in[i + 1][1] - (long) in[i][1] * in[i + 1][0];
		}
		ans = Math.abs(ans);
		return ans / 2 + (ans % 2 == 1 ? ".5" : ".0");
	}
}
