import java.util.Scanner;

public class N2748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		long lastNumber = 0;
		long nowNumber = 1;
		for (int i = 1; i < n; i++) {
			long temp = nowNumber;
			nowNumber += lastNumber;
			lastNumber = temp;
		}
		System.out.println(nowNumber);
	}
}
