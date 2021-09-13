import java.util.Scanner;

public class N17977 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int m = (int) (Math.log(n - 1) / Math.log(2));
		n -= Math.pow(2, m);
		int ans = (m - 1) * 2;
		if (n > Math.pow(2, m - 1)) {
			ans++;
		}
		System.out.print(ans);
	}
}
