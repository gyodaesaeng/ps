import java.util.*;

public class N2581 {
	public static boolean[] isCompositeNumber;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		isCompositeNumber = new boolean[n - m + 1];
		findCompositeNumber(m, n);
		int sum = 0;
		int minPrimeNumber = 0;
		for (int i = 0; i <= n - m; i++) {
			if (!isCompositeNumber[i]) {
				if (minPrimeNumber == 0) {
					minPrimeNumber = m + i;
				}
				sum += m + i;
			}
		}
		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(minPrimeNumber);
		}
	}

	public static void findCompositeNumber(int m, int n) {
		if (m == 1) {
			isCompositeNumber[0] = true;
		}
		for (int i = 2; i < n / 2; i++) {
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
}
