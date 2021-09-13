import java.util.Scanner;

public class N16283 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int w = sc.nextInt();
		sc.close();
		int x = solve(a, b, n, w);
		if (x > 0) {
			System.out.println(x + " " + (n - x));
		} else {
			System.out.println(-1);
		}
	}

	static int solve(int a, int b, int n, int w) {
		if ((a - b) * (w - b * n) > 0) {
			double x = (double) (w - b * n) / (a - b);
			if (x == Math.floor(x) && x > 0 && x < n) {
				return (int) x;
			} else {
				return -1;
			}
		} else {
			if (a + b == w && n == 2) {
				return 1;
			}
			return -1;
		}
	}
}