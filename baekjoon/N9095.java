import java.util.Scanner;

public class N9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ans = { 0, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274 };
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			System.out.println(ans[m]);
		}
		sc.close();
	}
}
