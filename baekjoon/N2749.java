import java.util.Scanner;

public class N2749 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		sc.close();
		int m = (int) (n % 1500000);
		long[][] a = { { 1, 1 }, { 1, 0 } };
		long[][] f = matrixSquare(a, m - 1, 2);
		System.out.println(f[0][0]);
	}

	static long[][] matrixMultifly(long[][] a, long[][] b, int row, int column) {
		long[][] c = new long[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				for (int k = 0; k < 2; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
				c[i][j] %= 1000000;
			}
		}
		return c;
	}

	static long[][] matrixSquare(long[][] a, int n, int row) {
		if (n <= 1) {
			return a;
		}
		if (n % 2 == 1) {
			long[][] b = matrixSquare(a, (n - 1) / 2, row);
			return matrixMultifly(matrixMultifly(b, b, row, row), a, row, row);
		}
		long[][] b = matrixSquare(a, n / 2, row);
		return matrixMultifly(b, b, row, row);
	}
}