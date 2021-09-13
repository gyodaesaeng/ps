import java.util.Scanner;

public class N1697 {
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		System.out.print(bt(k));
	}

	static int bt(int k) {
		if (n >= k) {
			return n - k;
		}
		if (k - 1 == n) {
			return 1;
		}
		if (k % 2 == 0) {
			return Math.min(bt(k / 2) + 1, k - n);
		}
		return Math.min(Math.min(bt((k + 1) / 2), bt((k - 1) / 2)) + 2, k - n);
	}
}
