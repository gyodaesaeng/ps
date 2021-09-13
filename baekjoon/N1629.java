import java.util.Scanner;

public class N1629 {
	static int a, b, c;

	public static void main(String[] args) {
		input();
		System.out.println(solve(a, b));
	}

	static void input() {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		sc.close();
	}

	static long solve(long a, long b) {
		if (b == 0) {
			return 1;
		}
		long temp = solve((a * a) % c, b / 2);
		if (b % 2 == 1) {
			temp = temp * a % c;
		}
		return temp;
	}
}
