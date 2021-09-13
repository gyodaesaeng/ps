import java.util.Arrays;
import java.util.Scanner;

public class N2752 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] n = new int[3];
		for (int i = 0; i < 3; i++) {
			n[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(n);
		for (int i : n) {
			System.out.print(i + " ");
		}
	}
}
