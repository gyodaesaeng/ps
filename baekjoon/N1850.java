import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class N1850 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long a = sc.nextLong();
		long b = sc.nextLong();
		sc.close();
		BigInteger a1 = BigInteger.valueOf(a);
		BigInteger b1 = BigInteger.valueOf(b);
		BigInteger gcd = a1.gcd(b1);
		long n = gcd.longValue();
		for (int i = 0; i < n; i++) {
			bw.write('1');
		}
		bw.flush();
	}
}
