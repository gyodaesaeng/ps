import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N13560 {
	static int n;
	static int[] win;
	static int[][] c;

	public static void main(String[] args) throws IOException {
		input();
		if (can()) {
			System.out.println("1");
		} else {
			System.out.println("-1");
		}
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ArrayList<Integer> beforeSort = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			beforeSort.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(beforeSort);
		win = new int[n];
		for (int i = 0; i < n; i++) {
			win[i] = beforeSort.get(i);
		}
		c = new int[n + 1][3];
	}

	static boolean can() {
		int sum = win[0];
		for (int i = 1; i < n; i++) {
			sum += win[i];
			if (sum < combination(i + 1, 2)) {
				return false;
			}
		}
		if (sum != combination(n, 2)) {
			return false;
		}
		return true;
	}

	static int combination(int a, int b) {
		if (c[a][b] > 0) {
			return c[a][b];
		}
		if (b == 0 || b == a) {
			return c[a][b] = 1;
		}
		return c[a][b] = combination(a - 1, b) + combination(a - 1, b - 1);
	}
}
