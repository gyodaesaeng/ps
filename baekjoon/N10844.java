import java.util.Scanner;

public class N10844 {
	static int[][] number;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		number = new int[n + 1][11];
		int sum = 0;
		for (int i = 1; i <= 9; i++) {
			sum += getNumber(n, i);
			sum %= 1000000000;
		}
		System.out.println(sum);
	}

	static int getNumber(int n, int k) {
		if (number[n][k] != 0) {
			return number[n][k];
		}
		if (n == 1) {
			return 1;
		}
		if (k == 0) {
			number[n][k] = getNumber(n - 1, 1);
		}
		if (k == 9) {
			number[n][k] = getNumber(n - 1, 8);
		}
		if (k > 0 && k < 9) {
			number[n][k] = getNumber(n - 1, k - 1) + getNumber(n - 1, k + 1);
		}
		number[n][k] %= 1000000000;
		return number[n][k];
	}
}
