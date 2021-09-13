import java.io.*;
import java.util.StringTokenizer;

public class N6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			System.out.println(solve(m, n, x, y));
		}
	}

	public static int leastCommonMultiple(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int n = a * b;
		int remainder = a % b;
		while (remainder > 0) {
			remainder = a % b;
			a = b;
			b = remainder;
		}
		return n / a;
	}

	public static int solve(int m, int n, int x, int y) {
		int max = leastCommonMultiple(m, n);
		if (x == m) {
			if (y == n) {
				return (max);
			} else {
				x = 0;
			}
		} else if (y == n) {
			y = 0;
		}
		if (m < n) {
			int temp = m;
			m = n;
			n = temp;
			temp = x;
			x = y;
			y = temp;
		}
		int year = x;
		if (year == 0) {
			year += m;
		}
		while (true) {
			if (year % n == y) {
				return year;
			}
			year += m;
			if (year > max) {
				return -1;
			}
		}
	}
}
