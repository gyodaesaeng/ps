import java.util.ArrayList;
import java.util.Scanner;

public class N17968 {
	static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		a = new int[n + 2];
		a[0] = a[1] = 1;
		System.out.print(dp(n));
	}

	static int dp(int n) {
		if (a[n] > 0) {
			return a[n];
		}
		boolean[] cant = new boolean[n + 1];
		for (int k = 1; 2 * k <= n; k++) {
			int temp = 2 * dp(n - k) - dp(n - 2 * k);
			if (temp <= n && temp > 0) {
				cant[temp] = true;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!cant[i]) {
				return a[n] = i;
			}
		}
		return -1;
	}
}
