import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16288 {
	static int n, k;
	static int[] p, row;

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
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p = new int[n];
		row = new int[k + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
	}

	static boolean solve() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				if (row[j] < p[i]) {
					row[j] = p[i];
					for (int l = j; l > 0; l--) {
						if (row[l] > row[l - 1]) {
							int temp = row[l];
							row[l] = row[l - 1];
							row[l - 1] = temp;
						} else {
							break;
						}
					}
					break;
				} else if (j == k - 1) {
					return false;
				}
			}
		}
		return true;
	}
}