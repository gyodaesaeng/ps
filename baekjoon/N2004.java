import java.util.Scanner;

public class N2004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		if (2 * m > n) {
			m = n - m;
		}
		System.out.println(Math.min(get(n, 2) - get(m, 2) - get(n - m, 2), get(n, 5) - get(m, 5) - get(n - m, 5)));
	}

	static int get(int n, int r) {
		int ans = 0;
		for (long i = r; i <= n; i *= r) {
			ans += n / i;
		}
		return ans;
	}
}
