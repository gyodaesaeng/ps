import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6591 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if (n == 0 && k == 0) {
				break;
			}
			if (k > n - k) {
				k = n - k;
			}
			System.out.println(combination(n, k));
		}
	}

	private static long combination(int n, int k) {
		long a = 1;
		for (int i = 1; i <= k; i++) {
			a *= n - i + 1;
			a /= i;
		}
		return a;
	}

}
