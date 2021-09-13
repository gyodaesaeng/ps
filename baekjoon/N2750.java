import java.util.Arrays;
import java.util.Scanner;

public class N2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nList = new int[n];
		for (int i = 0; i < n; i++) {
			nList[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(nList);
		for (int i = 0; i < n; i++) {
			System.out.println(nList[i]);
		}
	}
}
