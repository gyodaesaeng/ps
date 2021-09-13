import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1654 {
	static int n, k, max;
	static int[] a;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve(1, max / 2 + 1, max));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		a = new int[k];
		max = 0;
		for (int i = 0; i < k; i++) {
			a[i] = Integer.parseInt(br.readLine());
			if (max < a[i]) {
				max = a[i];
			}
		}
	}

	static long solve(long min, long mid, long max) {
		int temp = 0;
		for (int i = 0; i < k; i++) {
			temp += a[i] / mid;
		}
		if (temp >= n) {
			if (min >= max) {
				return max;
			}
			return solve(mid, (mid + max) / 2 + 1, max);
		} else {
			return solve(min, (min + mid) / 2, mid - 1);
		}
	}
}
