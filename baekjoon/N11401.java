import java.util.Scanner;

public class N11401 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		long answer = 1;
		long a = 1;
		long b = 1;
		for (int i = 1; i <= n; i++) {
			a *= i;
			a %= 1000000007;
		}
		for (int i = 1; i <= k; i++) {
			b *= i;
			b %= 1000000007;
		}
		for (int i = 1; i <= n - k; i++) {
			b *= i;
			b %= 1000000007;
		}
		long c = longPow(b, 1000000005);
		answer = a * c;
		answer %= 1000000007;
		System.out.println(answer);
	}

	private static long longPow(long a, long b) {
		long answer = 1;
		while (b > 0) {
			if (b % 2 != 0) {
				answer *= a;
				answer %= 1000000007;
			}
			a *= a;
			a %= 1000000007;
			b /= 2;
		}
		return answer;
	}
}
