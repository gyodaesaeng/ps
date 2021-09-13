import java.util.Scanner;

public class N2455 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int now = 0;
		int max = 0;
		for (int i = 0; i < 4; i++) {
			now -= sc.nextInt();
			now += sc.nextInt();
			if (now > max) {
				max = now;
			}
		}
		sc.close();
		System.out.println(max);
	}
}
