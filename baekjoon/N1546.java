import java.util.*;

public class N1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int sum = 0;
		int temp;
		for (int i = 0; i < n; i++) {
			temp = sc.nextInt();
			sum += temp;
			if (temp > max) {
				max = temp;
			}
		}
		sc.close();
		System.out.println((float) (sum * 100) / (max * n));
	}
}
