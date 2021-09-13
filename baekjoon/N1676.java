import java.util.Scanner;

public class N1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int twe = 0;
		int five = 0;
		for (int i = 1; i <= n; i++) {
			int a = i;
			while (a % 2 == 0) {
				a /= 2;
				twe++;
			}
			while (a % 5 == 0) {
				a /= 5;
				five++;
			}
		}
		if (twe > five) {
			System.out.println(five);
		} else {
			System.out.println(twe);
		}
	}
}
