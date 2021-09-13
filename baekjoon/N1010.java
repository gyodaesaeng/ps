import java.math.BigInteger;
import java.util.Scanner;

public class N1010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(fact(m).divide(fact(n)).divide(fact(m - n)));
		}
		sc.close();
	}

	static BigInteger fact(int n) {
		BigInteger ans = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			ans = ans.multiply(BigInteger.valueOf(i));
		}
		return ans;
	}
}
