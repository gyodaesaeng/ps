import java.util.*;

public class N2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int m = 0;
		int temp = 0;
		while (n > 0) {
			if (n % 3 == 0) {
				temp = m + (n / 3);
			}
			n -= 5;
			m++;
		}
		if (n == 0) {
			System.out.println(m);
		} else {
			if (temp > 0) {
				System.out.println(temp);
			} else {
				System.out.println(-1);
			}
		}
	}
}