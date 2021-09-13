import java.util.ArrayList;
import java.util.Scanner;

public class N1016 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		sc.close();
		int maxSqrt = (int) (Math.ceil(Math.sqrt(max))) + 1;
		int maxSSqrt = (int) (Math.ceil(Math.sqrt(maxSqrt))) + 1;
		ArrayList<Long> prime = new ArrayList<Long>();
		boolean[] check = new boolean[maxSqrt + 1];
		for (int i = 2; i <= maxSSqrt; i++) {
			for (int j = i; i * j <= maxSqrt; j++) {
				check[i * j] = true;
			}
		}
		for (int i = 2; i <= maxSqrt; i++) {
			if (!check[i]) {
				prime.add((long) i);
			}
		}
		check = new boolean[(int) (max - min + 1)];
		for (long i : prime) {
			long pow = i * i;
			long b = min / pow;
			while (b * pow < min) {
				b++;
			}
			for (long j = b; pow * j <= max; j++) {
				check[(int) (pow * j - min)] = true;
			}
		}
		int ans = 0;
		for (boolean i : check) {
			if (!i) {
				ans++;
			}
		}
		System.out.print(ans);
	}
}
