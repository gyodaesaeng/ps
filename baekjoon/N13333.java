import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N13333 {
	static int n;
	static ArrayList<Integer> in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			in.add(Integer.parseInt(st.nextToken()));
		}
	}

	static int solve() {
		Collections.sort(in);
		for (int i = 1; i < n; i++) {
			if (in.get(n - i) >= i && in.get(n - i - 1) <= i) {
				return i;
			}
		}
		return Math.min(in.get(0), n);
	}
}
