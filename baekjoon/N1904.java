import java.util.Scanner;

public class N1904 {
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		memo = new int[n + 1];
		memo[1] = 1;
		memo[2] = 2;
		System.out.println(solve(n));
	}

	static int solve(int n) {
		if (memo[n] > 0) {
			return memo[n];
		}
		memo[n] = (solve(n - 1) + solve(n - 2)) % 15746;
		return memo[n];
	}
}
