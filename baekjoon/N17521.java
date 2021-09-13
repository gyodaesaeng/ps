import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17521 {
	static int n;
	static long w;
	static int[] s;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = Integer.parseInt(br.readLine());
		}
	}

	static long solve() {
		long b = 0;
		for (int i = 0; i < n - 1; i++) {
			if (s[i] < s[i + 1]) {
				b += w / s[i];
				w %= s[i];
			} else {
				w += b * s[i];
				b = 0;
			}
		}
		w += b * s[n - 1];
		return w;
	}
}
