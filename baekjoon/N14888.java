import java.util.Scanner;

public class N14888 {
	static int n;
	static int[] a, b;

	public static void main(String[] args) {
		input();
		output(solve(a[0], 1, b));
	}

	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		b = new int[4];
		for (int i = 0; i < 4; i++) {
			b[i] = sc.nextInt();
		}
		sc.close();
	}

	static int[] solve(int last, int index, int[] c) {
		int[] ans = new int[2];
		ans[0] = Integer.MAX_VALUE;
		ans[1] = Integer.MIN_VALUE;
		if (index == n) {
			ans[0] = last;
			ans[1] = last;
			return ans;
		}
		for (int i = 0; i < 4; i++) {
			if (c[i] > 0) {
				c[i]--;
				int temp = last;
				switch (i) {
				case 0:
					temp += a[index];
					break;
				case 1:
					temp -= a[index];
					break;
				case 2:
					temp *= a[index];
					break;
				case 3:
					temp /= a[index];
					break;
				}
				int[] t = solve(temp, index + 1, c);
				if (t[0] < ans[0]) {
					ans[0] = t[0];
				}
				if (t[1] > ans[1]) {
					ans[1] = t[1];
				}
				c[i]++;
			}
		}
		return ans;
	}

	static void output(int[] ans) {
		System.out.println(ans[1]);
		System.out.println(ans[0]);
	}
}
