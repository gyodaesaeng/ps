import java.util.Arrays;
import java.util.Scanner;

public class N17626 {
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		memo = new int[n + 1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		System.out.print(dp(n));
	}

	static int dp(int n) {
		if (memo[n] > -1) {
			return memo[n];
		}
		int min = 4;
		for (int i = (int) Math.sqrt(n); i > 0; i--) {
			min = Math.min(min, dp(n - i * i));
		}
		return memo[n] = min + 1;
	}
}
