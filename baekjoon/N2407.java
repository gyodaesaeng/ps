import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger;

public class N2407 {
	static ArrayList<ArrayList<BigInteger>> c = new ArrayList<ArrayList<BigInteger>>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		for (int i = 0; i <= n; i++) {
			c.add(new ArrayList<BigInteger>());
			for (int j = 0; j <= n / 2; j++) {
				c.get(i).add(null);
			}
		}
		System.out.println(combination(n, k).toString());
	}

	private static BigInteger combination(int n, int k) {
		if (k > n / 2) {
			k = n - k;
		}
		if (c.get(n).get(k) == null) {
			BigInteger value;
			if (k == 0) {
				value = new BigInteger("1");
			} else {
				value = combination(n - 1, k - 1).add(combination(n - 1, k));
			}
			c.get(n).set(k, value);
			return value;
		} else {
			return c.get(n).get(k);
		}
	}
}
