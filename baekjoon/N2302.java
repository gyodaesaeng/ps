import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2302 {
	static int n, m;
	static int[] vip, memo;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		vip = new int[m + 2];
		vip[0] = 0;
		vip[m + 1] = n + 1;
		for (int i = 1; i <= m; i++) {
			vip[i] = Integer.parseInt(br.readLine());
		}
	}

	static int solve() {
		int ans = 1;
		memo = new int[n + 1];
		memo[0] = 1;
		memo[1] = 1;
		for (int i = 0; i <= m; i++) {
			ans *= dp(vip[i + 1] - vip[i] - 1);
		}
		return ans;
	}

	static int dp(int num) {
		if (memo[num] > 0) {
			return memo[num];
		}
		return memo[num] = dp(num - 1) + dp(num - 2);
	}
}
