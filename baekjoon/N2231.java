import java.util.Scanner;

public class N2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int temp = n;
		int length = 0;
		while (temp > 0) {
			temp /= 10;
			length++;
		}
		int ans = 0;
		for (int i = 1; i <= 9 * length; i++) {
			temp = n - i;
			int v = temp;
			while (temp > 0) {
				v += temp % 10;
				temp /= 10;
			}
			if (v == n) {
				ans = n - i;
			}
		}
		System.out.println(ans);
	}
}
