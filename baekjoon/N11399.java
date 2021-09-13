import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11399 {
	static int n;
	static int[] p;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		p = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
	}

	static int solve() {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += p[i] * (n - i);
		}
		return ans;
	}
}
