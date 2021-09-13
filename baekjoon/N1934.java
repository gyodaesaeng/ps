import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(a * b / gcd(a, b));
		}
	}

	static int gcd(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int r = 1;
		while (r > 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
