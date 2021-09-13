import java.util.Scanner;

public class N10797 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 0;
		for (int i = 0; i < 5; i++) {
			if (sc.nextInt() == n) {
				m++;
			}
		}
		sc.close();
		System.out.print(m);
	}
}
