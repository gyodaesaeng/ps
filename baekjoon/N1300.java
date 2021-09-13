import java.util.Scanner;

public class N1300 {
	static long n, k;

	public static void main(String[] args) {
		input();
		System.out.println(solve(1, n * n));
	}

	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		sc.close();
	}

	static long solve(long min, long max) {
		long mid = (min + max) / 2;
		long temp = 0;
		for (int i = 1; i <= n; i++) {
			temp += Math.min(mid / i, n);
		}
		if (temp >= k) {
			if (min == max) {
				return mid;
			}
			return solve(min, mid);
		}
		return solve(mid + 1, max);
	}
}
