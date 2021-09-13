import java.util.Scanner;

public class N3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] rest = new boolean[42];
		for (int i = 0; i < 10; i++) {
			rest[sc.nextInt() % 42] = true;
		}
		sc.close();
		int n = 0;
		for (int i = 0; i < 42; i++) {
			if (rest[i]) {
				n++;
			}
		}
		System.out.println(n);
	}
}
