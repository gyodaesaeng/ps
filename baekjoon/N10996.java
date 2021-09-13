import java.util.Scanner;

public class N10996 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		String s = "";
		for (int i = 0; i < n; i++) {
			s += i % 2 == 0 ? '*' : ' ';
		}
		s += "\n";
		for (int i = 0; i < n; i++) {
			s += i % 2 == 0 ? ' ' : '*';
		}
		for (int i = 0; i < n; i++) {
			System.out.println(s);
		}
	}

}
