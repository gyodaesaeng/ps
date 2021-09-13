import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14002 {
	static int n, ans;
	static int[] in, memo, check;
	static ArrayList<Integer> path;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		memo = new int[n];
		Arrays.fill(memo, Integer.MAX_VALUE);
		check = new int[n];
		ans = 0;
		memo[ans] = in[0];
		check[0] = ans++;
		for (int i = 1; i < n; i++) {
			if (memo[ans - 1] < in[i]) {
				memo[ans] = in[i];
				check[i] = ans++;
				continue;
			}
			int index = Arrays.binarySearch(memo, in[i]);
			if (index < 0) {
				index = -index - 1;
				memo[index] = in[i];
				check[i] = index;
			}
		}
		path = new ArrayList<Integer>();
		for (int i = n - 1; i >= 0 && path.size() != ans; i--) {
			if (check[i] == ans - path.size() - 1) {
				path.add(in[i]);
			}
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(ans + "\n");
		for (int i = ans - 1; i >= 0; i--) {
			bw.write(path.get(i) + " ");
		}
		bw.flush();
	}
}
