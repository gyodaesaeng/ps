import java.util.Scanner;

public class N18301 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] n = new int[3];
		for (int i = 0; i < 3; i++) {
			n[i] = sc.nextInt();
		}
		sc.close();
		System.out.print((int) ((n[0] + 1) * (n[1] + 1) / (n[2] + 1)) - 1);
	}
}
