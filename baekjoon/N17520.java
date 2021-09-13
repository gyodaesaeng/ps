import java.util.Scanner;

public class N17520 {
	static int n;

	public static void main(String[] args) {
		input();
		System.out.println(solve());
	}

	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
	}

	static long solve() {
		return pow((n + 1) / 2);
	}

	static long pow(int k) {
		if (k == 1) {
			return 2;
		}
		long ans = pow(k / 2);
		ans *= ans;
		if (k % 2 == 1) {
			ans *= 2;
		}
		return ans % 16769023;
	}
}
