import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2217 {
	static int n;
	static int[] a;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);
	}

	static int solve() {
		int w = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] * (n - i) > w) {
				w = a[i] * (n - i);
			}
		}
		return w;
	}
}
