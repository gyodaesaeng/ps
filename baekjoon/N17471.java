import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N17471 {
	static int n, s;
	static boolean[][] a;
	static boolean[] b;
	static int[] h;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		h = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		a = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				a[i][Integer.parseInt(st.nextToken()) - 1] = true;
			}
		}
	}

	static void solve() {
		b = new boolean[n];
		int ans = bt(1);
		if (ans == 1000) {
			ans = -1;
		}
		System.out.println(ans);
	}

	static int bt(int i) {
		if (i == n) {
			int minT = n;
			int minF = n;
			int nt = 0;
			int nf = 0;
			for (int j = 0; j < n; j++) {
				if (b[j]) {
					if (minT == n) {
						minT = j;
					}
					nt++;
				} else {
					if (minF == n) {
						minF = j;
					}
					nf++;
				}
			}
			if (nt == 0) {
				return 1000;
			}
			if (dfs(true, minT, nt) && dfs(false, minF, nf)) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					if (b[j]) {
						sum += h[j];
					} else {
						sum -= h[j];
					}
				}
				return Math.abs(sum);
			}
			return 1000;
		}
		b[i] = true;
		int temp = bt(i + 1);
		b[i] = false;
		return Math.min(temp, bt(i + 1));
	}

	static boolean dfs(boolean t, int s, int number) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(s);
		boolean[] check = new boolean[n];
		check[s] = true;
		int count = 1;
		while (!stack.empty()) {
			boolean temp = false;
			for (int i = 0; i < n; i++) {
				if (a[stack.peek()][i] && !t ^ b[i] && !check[i]) {
					check[i] = true;
					stack.push(i);
					temp = true;
					count++;
					break;
				}
			}
			if (!temp) {
				stack.pop();
			}
		}
		if (count == number) {
			return true;
		} else {
			return false;
		}
	}
}
