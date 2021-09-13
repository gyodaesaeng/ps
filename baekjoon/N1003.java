import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] p = new int[41];
		p[0] = 0;
		p[1] = 1;
		for (int i = 2; i <= 40; i++) {
			p[i] = p[i - 1] + p[i - 2];
		}
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n < 1) {
				System.out.println("1 0");
			} else {
				System.out.println(Integer.toString(p[n - 1]) + ' ' + Integer.toString(p[n]));
			}
		}
	}
}
