import java.util.ArrayList;
import java.util.Scanner;

public class N11051 {
	static ArrayList<ArrayList<Integer>> c = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		for (int i = 0; i <= n; i++) {
			c.add(new ArrayList<Integer>());
			for (int j = 0; j <= n / 2; j++) {
				c.get(i).add(null);
			}
		}
		System.out.println(combination(n, k));
	}

	private static int combination(int n, int k) {
		if (k > n / 2) {
			k = n - k;
		}
		if (c.get(n).get(k) == null) {
			int value;
			if (k == 0) {
				value = 1;
			} else {
				value = (combination(n - 1, k - 1) + combination(n - 1, k)) % 10007;
			}
			c.get(n).set(k, value);
			return value;
		} else {
			return c.get(n).get(k);
		}
	}
}
