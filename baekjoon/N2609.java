import java.util.Scanner;

public class N2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		System.out.println(gcd(a, b));
		System.out.println(a * b / gcd(a, b));
	}

	static int gcd(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int r = 1;
		while (r > 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
