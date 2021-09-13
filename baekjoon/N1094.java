import java.util.Scanner;

public class N1094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		boolean[] a = new boolean[7];
		for (int i = 0; x > 0; i++) {
			if (x % 2 == 1) {
				a[i] = true;
			}
			x /= 2;
		}
		int answer = 0;
		for (int i = 0; i < 7; i++) {
			if (a[i]) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
