import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N11653 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int m = 2;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (n > 1) {
			if (n % m == 0) {
				bw.write(m + "\n");
				n /= m;
			} else {
				m++;
			}
		}
		bw.flush();
	}
}
