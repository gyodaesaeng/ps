import java.util.Scanner;

public class N2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		int temp = m;
		for (int i = 0; i < 3; i++) {
			System.out.println(n * (temp % 10));
			temp /= 10;
		}
		System.out.print(n * m);
	}
}
