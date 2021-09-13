import java.util.Scanner;

public class N5543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] in = new int[5];
		for (int i = 0; i < 5; i++) {
			in[i] = sc.nextInt();
		}
		sc.close();
		System.out.print(Math.min(in[0], Math.min(in[1], in[2])) + Math.min(in[3], in[4]) - 50);
	}
}
