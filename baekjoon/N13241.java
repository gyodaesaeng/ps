import java.util.Scanner;

public class N13241 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		sc.close();
		System.out.println(a * b / gcd(a, b));
	}

	static long gcd(long a, long b) {
		if (a < b) {
			long temp = a;
			a = b;
			b = temp;
		}
		long r = 1;
		while (r > 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
