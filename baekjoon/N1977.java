import java.util.Scanner;

public class N1977 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		double mSqrt = Math.sqrt(m);
		m = (int) mSqrt;
		if (m < mSqrt) {
			m++;
		}
		double nSqrt = Math.sqrt(n);
		n = (int) nSqrt;
		int sum = 0;
		for (int i = m; i <= n; i++) {
			sum += i * i;
		}
		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(m * m);
		}
	}
}
