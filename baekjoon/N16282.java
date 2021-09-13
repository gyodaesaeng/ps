import java.util.Scanner;

public class N16282 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		sc.close();
		long k = 1;
		while ((long) (k + 1) * (pow(k + 1) - 1) + k < n) {
			k++;
		}
		System.out.println(k);
	}

	static long pow(long k) {
		if (k == 1) {
			return 2;
		}
		long temp = pow(k / 2);
		if (k % 2 == 0) {
			return temp * temp;
		} else {
			return temp * temp * 2;
		}
	}
}
