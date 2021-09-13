import java.util.Scanner;

public class N11758 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] in = new int[4][2];
		for (int i = 0; i < 3; i++) {
			in[i][0] = sc.nextInt();
			in[i][1] = sc.nextInt();
		}
		sc.close();
		in[3][0] = in[0][0];
		in[3][1] = in[0][1];
		int s = 0;
		for (int i = 0; i < 3; i++) {
			s += in[i][0] * in[i + 1][1] - in[i][1] * in[i + 1][0];
		}
		if (s > 0) {
			System.out.print(1);
		}
		if (s == 0) {
			System.out.print(0);
		}
		if (s < 0) {
			System.out.print(-1);
		}
	}
}
