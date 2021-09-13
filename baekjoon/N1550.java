import java.util.Scanner;

public class N1550 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str = sc.nextLine().toCharArray();
		sc.close();
		int ans = 0;
		for (char c : str) {
			if (c >= 'A') {
				c -= 'A' - 10;
			} else {
				c -= '0';
			}
			ans = ans * 16 + c;
		}
		System.out.print(ans);
	}
}
