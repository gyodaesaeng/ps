import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N10816 {
	static int n, m;
	static ArrayList<Integer> a, b;

	public static void main(String[] args) throws IOException {
		input();
		output(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		b = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			b.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(a);
	}

	static int[] solve() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int lastN = a.get(0);
		int number = 1;
		for (int i = 1; i < n; i++) {
			if (lastN == a.get(i)) {
				number++;
			} else {
				map.put(a.get(i - 1), number);
				lastN = a.get(i);
				number = 1;
			}
		}
		map.put(a.get(n - 1), number);
		int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			if (map.containsKey(b.get(i))) {
				ans[i] = map.get(b.get(i));
			}
		}
		return ans;
	}

	static void output(int[] ans) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < m; i++) {
			bw.write(ans[i] + " ");
		}
		bw.flush();
	}
}