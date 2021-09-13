import java.util.Scanner;

public class N1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int m = 666;
		int k = 1;
		while (k != n) {
			m++;
			int temp = m;
			while (temp > 100) {
				if (temp % 1000 == 666) {
					k++;
					break;
				}
				temp /= 10;
			}
		}
		System.out.println(m);
	}
}
