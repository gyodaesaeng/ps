import java.util.Scanner;

public class N3053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		sc.close();
		System.out.println((double) Math.PI * r * r);
		System.out.println(2 * r * r);
	}
}
