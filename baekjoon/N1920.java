import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1920 {
	static int n, m;
	static ArrayList<Integer> a;
	static int[] b;

	public static void main(String[] args) throws IOException {
		input();
		output(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		m = Integer.parseInt(br.readLine());
		b = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
	}

	static boolean[] solve() {
		Collections.sort(a);
		boolean[] ans = new boolean[m];
		for (int i = 0; i < m; i++) {
			int l = 0;
			int r = n - 1;
			while (l <= r) {
				if (a.get((l + r) / 2) == b[i]) {
					ans[i] = true;
					break;
				} else if (a.get((l + r) / 2) > b[i]) {
					r = (l + r) / 2 - 1;
				} else {
					l = (l + r) / 2 + 1;
				}
			}
		}
		return ans;
	}

	static void output(boolean[] ans) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < m; i++) {
			if (ans[i]) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}
		bw.flush();
	}
}
