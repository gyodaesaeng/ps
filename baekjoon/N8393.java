import java.util.Scanner;

public class N8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.print(n * (n + 1) / 2);
	}
}
