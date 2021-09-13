import java.util.Scanner;

public class N2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		sc.close();
		if (v > a) {
			System.out.println((int) Math.ceil((double) (v - a) / (a - b)) + 1);
		} else {
			System.out.println(1);
		}
	}
}
