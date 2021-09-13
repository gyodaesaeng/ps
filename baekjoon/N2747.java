import java.util.Scanner;

public class N2747 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int lastNumber = 0;
		int nowNumber = 1;
		for (int i = 1; i < n; i++) {
			int temp = nowNumber;
			nowNumber += lastNumber;
			lastNumber = temp;
		}
		System.out.println(nowNumber);
	}
}
