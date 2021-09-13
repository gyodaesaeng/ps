import java.util.Arrays;
import java.util.Scanner;

public class N3009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] x = new int[3];
		int[] y = new int[3];
		for (int i = 0; i < 3; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(x);
		Arrays.sort(y);
		if (x[0] == x[1]) {
			x[0] = x[2];
		}
		if (y[0] == y[1]) {
			y[0] = y[2];
		}
		System.out.println(x[0] + " " + y[0]);
	}
}
