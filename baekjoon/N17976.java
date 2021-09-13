import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N17976 {
	static int n;
	static T[] in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(bs(1, Integer.MAX_VALUE));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new T[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			in[i] = new T(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(in);
	}

	static long bs(long s, long e) {
		if (s == e) {
			return s;
		}
		long m = (s + e) / 2 + 1;
		long last = -m;
		for (T i : in) {
			if (last + m <= i.x) {
				last = i.x;
			} else {
				if (last + m <= i.x + i.l) {
					last += m;
				} else {
					return bs(s, m - 1);
				}
			}
		}
		return bs(m, e);
	}

	static class T implements Comparable<T> {
		int x, l;

		T(int x, int l) {
			this.x = x;
			this.l = l;
		}

		@Override
		public int compareTo(T o) {
			if (x > o.x) {
				return 1;
			}
			// TODO Auto-generated method stub
			return -1;
		}
	}
}
