import java.util.Scanner;

public class N13136 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		System.out.print((long) Math.ceil((double) r / n) * Math.ceil((double) c / n));
	}
}
