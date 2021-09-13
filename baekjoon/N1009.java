import java.util.Scanner;

public class N1009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int ans = solve(sc.nextInt() % 10, sc.nextInt());
			if (ans == 0) {
				ans = 10;
			}
			System.out.println(ans);
		}
		sc.close();
	}

	static int solve(int a, int b) {
		if (b == 1) {
			return a;
		}
		int temp = solve(a, b / 2);

		if (b % 2 == 0) {
			return temp * temp % 10;
		}
		return temp * temp * a % 10;
	}
}
