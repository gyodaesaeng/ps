import java.util.Scanner;

public class N10830 {
	static int n;
	static long b;
	static int[][] a;

	public static void main(String[] args) {
		input();
		a = solve(a, b);
		output();
	}

	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		b = sc.nextLong();
		a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt() % 1000;
			}
		}
		sc.close();
	}

	static int[][] solve(int[][] a, long b) {
		if (b == 1) {
			return a;
		}
		int[][] temp = solve(mM(a, a), b / 2);
		if (b % 2 == 1) {
			temp = mM(temp, a);
		}
		return temp;
	}

	static int[][] mM(int[][] a, int[][] b) {
		int[][] ans = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans[i][j] = 0;
				for (int k = 0; k < n; k++) {
					ans[i][j] += a[i][k] * b[k][j];
				}
				ans[i][j] %= 1000;
			}
		}
		return ans;
	}

	static void output() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
