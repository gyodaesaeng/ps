import java.util.Scanner;

public class N10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		if (a >= b) {
			if (a >= c) {
				if (b >= c) {
					System.out.print(b);
				} else {
					System.out.print(c);
				}
			} else {
				System.out.print(a);
			}
		} else {
			if (a >= c) {
				System.out.print(a);
			} else {
				if (b >= c) {
					System.out.print(c);
				} else {
					System.out.print(b);
				}
			}
		}
	}
}
