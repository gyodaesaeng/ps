import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N2110 {
	static int n, c;
	static ArrayList<Integer> x;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve(1, x.get(n - 1) - x.get(0)));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		x = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			x.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(x);
	}

	static long solve(long min, long max) {
		long mid = (max + min + 1) / 2;
		int number = 1;
		int last = 0;
		for (int i = 0; i < n; i++) {
			if (x.get(i) - x.get(last) >= mid) {
				last = i;
				number++;
			}
		}
		if (number >= c) {
			if (min == max) {
				return mid;
			}
			return solve(mid, max);
		}
		return solve(min, mid - 1);
	}
}
