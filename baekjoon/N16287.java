import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16287 {
	static int w, n;
	static int[] a;

	public static void main(String[] args) throws IOException {
		input();
		if (solve()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
	}

	static boolean solve() {
		boolean[] mark = new boolean[w];
		for (int i = 2; i < n; i++) {
			for (int j = 0; j < i - 1; j++) {
				if (a[i - 1] + a[j] < w) {
					mark[w - a[i - 1] - a[j]] = true;
				}
			}
			for (int j = i + 1; j < n; j++) {
				if (a[i] + a[j] < w) {
					if (mark[a[i] + a[j]]) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
