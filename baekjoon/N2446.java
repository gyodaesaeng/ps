import java.util.Scanner;

public class N2446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		String s = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				s += ' ';
			}
			for (int j = 1; j < 2 * (n - i); j++) {
				s += '*';
			}
			System.out.println(s);
			s = "";
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				s += ' ';
			}
			for (int j = 0; j <= 2 * i; j++) {
				s += "*";
			}
			System.out.println(s);
			s = "";
		}
	}
}
