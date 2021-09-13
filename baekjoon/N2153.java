import java.util.Scanner;

public class N2153 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		char[] chars = str.toCharArray();
		int sum = 0;
		for (char c : chars) {
			if (c >= 'a') {
				c -= 'a' - 1;
			} else {
				c -= 'A' - 27;
			}
			sum += c;
		}
		if (prime(sum)) {
			System.out.print("It is a prime word.");
		} else {
			System.out.print("It is not a prime word.");
		}

	}

	static boolean prime(int n) {
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
