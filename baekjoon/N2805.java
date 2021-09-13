import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N2805 {
	static int n, m;
	static ArrayList<Integer> a;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve(0, a.get(n - 1)));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(a);
	}

	static long solve(long min, long max) {
		long mid = (min + max + 1) / 2;
		long temp = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (a.get(i) > mid) {
				temp += a.get(i) - mid;
				if (temp >= m) {
					break;
				}
			} else {
				break;
			}
		}
		if (temp >= m) {
			if (min >= max) {
				return mid;
			}
			return solve(mid, max);
		} else {
			return solve(min, mid - 1);
		}
	}
}
