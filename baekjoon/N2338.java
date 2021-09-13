import java.math.BigInteger;
import java.util.Scanner;

public class N2338 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = new BigInteger(sc.nextLine());
		BigInteger b = new BigInteger(sc.nextLine());
		sc.close();
		System.out.println(a.add(b));
		System.out.println(a.add(b.multiply(BigInteger.valueOf(-1))));
		System.out.println(a.multiply(b));
	}
}
