import java.util.Scanner;

public class N1085 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		sc.close();
		if (x > w - x) {
			x = w - x;
		}
		if (y > h - y) {
			y = h - y;
		}
		System.out.println(Math.min(x, y));
	}
}
