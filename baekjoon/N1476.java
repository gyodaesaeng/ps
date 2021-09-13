import java.util.Scanner;

public class N1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		if (e == 15) {
			e = 0;
		}
		int s = sc.nextInt();
		int m = sc.nextInt();
		if (m == 19) {
			m = 0;
		}
		sc.close();
		int ans = s;
		while (ans % 15 != e || ans % 19 != m) {
			ans += 28;
		}
		System.out.print(ans);
	}
}
