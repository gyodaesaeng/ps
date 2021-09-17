import java.util.Scanner;

public class N11689 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		sc.close();
		long ans = n;
		for (long i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				while (n % i == 0) {
					n /= i;
				}
				ans /= i;
				ans *= i - 1;
			}
		}
		if (n > 1) {
			ans /= n;
			ans *= n - 1;
		}
		System.out.print(ans);
	}
}
