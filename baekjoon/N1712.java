import java.util.Scanner;

public class N1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		System.out.println(solve(a, b, c));
	}

	static int solve(int a, int b, int c) {
		if (c - b <= 0) {
			return -1;
		}
		return a / (c - b) + 1;
	}
}
