import java.util.Scanner;

public class N2523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		String s = "";
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				s += '*';
			}
			s += "\n";
		}
		for (int i = n; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				s += '*';
			}
			s += "\n";
		}
		System.out.print(s);
	}
}
