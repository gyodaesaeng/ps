import java.util.Scanner;

public class N1929 {
	public static boolean[] isCompositeNumber;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		isCompositeNumber = new boolean[n - m + 1];
		findCompositeNumber(m, n);
		print(m, n);
	}

	public static void findCompositeNumber(int m, int n) {
		if (m == 1) {
			isCompositeNumber[0] = true;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			int j;
			if (m / i > i) {
				if (m % i > 0) {
					j = (m / i) + 1;
				} else {
					j = m / i;
				}
			} else {
				j = i;
			}
			while (i * j < m) {
				j++;
			}
			while (i * j <= n) {
				isCompositeNumber[(i * j++) - m] = true;
			}
		}
	}

	public static void print(int m, int n) {
		for (int i = 0; i <= n - m; i++) {
			if (!isCompositeNumber[i]) {
				System.out.println(i + m);
			}
		}

	}
}
