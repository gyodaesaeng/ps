import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1086 {
	static int n, k;
	static int[] inMod, inLength, mod;
	static String[] in;
	static long[][] memo;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new String[n];
		for (int i = 0; i < n; i++) {
			in[i] = br.readLine();
		}
		k = Integer.parseInt(br.readLine());
	}

	static String solve() {
		inMod = new int[n];
		inLength = new int[n];
		mod = new int[51];
		mod[0] = 1 % k;
		for (int i = 1; i <= 50; i++) {
			mod[i] = (mod[i - 1] * 10) % k;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < in[i].length(); j++) {
				inMod[i] = (inMod[i] * 10 + (in[i].charAt(j) - '0')) % k;
			}
		}
		memo = new long[1 << n][k];
		for (int i = 0; i < (1 << n) - 1; i++) {
			Arrays.fill(memo[i], -1);
		}
		Arrays.fill(memo[(1 << n) - 1], 0);
		memo[(1 << n) - 1][0] = 1;
		long fact = 1;
		for (int i = 2; i <= n; i++) {
			fact *= i;
		}
		long p = dp(0, 0);
		if (p == 0) {
			return "0/1";
		}
		long a = fact;
		long b = p;
		while (b > 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return p / a + "/" + fact / a;
	}

	static long dp(int v, int lastMod) {
		if (memo[v][lastMod] >= 0) {
			return memo[v][lastMod];
		}
		long sum = 0;
		for (int i = 0; i < n; i++) {
			if ((v & (1 << i)) == 0) {
				sum += dp(v | (1 << i), (mod[in[i].length()] * lastMod + inMod[i]) % k);
			}
		}
		return memo[v][lastMod] = sum;
	}
}
