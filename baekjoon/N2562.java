import java.util.Scanner;

public class N2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n[] = new int[9];
		int maxP = 0;
		for (int i = 0; i < 9; i++) {
			n[i] = sc.nextInt();
			if (n[i] > n[maxP]) {
				maxP = i;
			}
		}
		sc.close();
		System.out.println(n[maxP]);
		System.out.println(maxP + 1);
	}
}
