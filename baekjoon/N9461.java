import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9461 {
	static long[] p = new long[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		p[5] = 2;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(getP(n));
		}
	}

	static long getP(int n) {
		if (p[n] > 0) {
			return p[n];
		}
		return p[n] = getP(n - 1) + getP(n - 5);
	}
}
