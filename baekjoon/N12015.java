import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12015 {
	static int n;
	static int[] a, b;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
	}

	static int solve() {
		b = new int[n + 1];
		b[1] = a[0];
		int len = 1;
		for (int i = 1; i < n; i++) {
			if (b[len] < a[i]) {
				b[++len] = a[i];
			} else {
				int temp = find(0, len, a[i]) + 1;
				b[temp] = Math.min(a[i], b[temp]);
			}
		}
		return len;
	}

	static int find(int min, int max, int x) {
		int mid = (min + max + 1) / 2;
		if (b[mid] < x) {
			if (min == max) {
				return mid;
			}
			return find(mid, max, x);
		}
		return find(min, mid - 1, x);
	}
}
