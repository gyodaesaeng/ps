import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N13458 {
	static int n, b, c;
	static int[] a;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	}

	static void solve() {
		long teacher = n;
		for (int i = 0; i < n; i++) {
			a[i] -= b;
			if (a[i] > 0) {
				teacher += (a[i] + c - 1) / c;
			}
		}
		System.out.println(teacher);
	}
}
