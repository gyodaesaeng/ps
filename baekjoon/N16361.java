import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N16361 {
	static int n, m;
	static Led[] led;

	public static void main(String[] args) throws IOException {
		input();
		output(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		led = new Led[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			led[i] = new Led(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}

	static long solve() {
		Arrays.sort(led);
		if (led[0].v == 0) {
			return bs(led[0].l * 2, Integer.MAX_VALUE);
		} else {
			return bs(0, Integer.MAX_VALUE);
		}
	}

	static void output(long ans) {
		String str = ans / 2 + ".";
		if (ans % 2 == 1) {
			str += "5";
		} else {
			str += "0";
		}
		System.out.print(str);
	}

	static long bs(long min, long max) {
		if (min == max) {
			return min;
		}
		long mid = (min + max) / 2;
		int v1 = n - 1;
		for (int i = 0; i < n; i++) {
			if (led[i].l * 2 > mid) {
				v1 = i;
				break;
			}
		}
		int lmin = led[v1].l;
		int lmax = led[v1].l;
		int v2 = n - 1;
		for (int i = v1; i < n; i++) {
			if (led[i].l > lmax) {
				lmax = led[i].l;
			}
			if (led[i].l < lmin) {
				lmin = led[i].l;
			}
			if (lmax - lmin > mid) {
				v2 = i;
				break;
			}
		}
		long lmid = lmax * 2 - mid;
		lmin = led[v2].l;
		lmax = led[v2].l;
		for (int i = v2; i < n; i++) {
			if (led[i].l > lmax) {
				lmax = led[i].l;
			}
			if (led[i].l < lmin) {
				lmin = led[i].l;
			}
			if (lmax - lmin > mid) {
				return bs(mid + 1, max);
			}
		}
		if (lmax + lmin < lmid && lmid > lmin * 2 + mid) {
			return bs(mid + 1, max);
		}
		return bs(min, mid);
	}
}

class Led implements Comparable<Led> {
	int v, l;

	Led(int v, int l) {
		this.v = v;
		this.l = l;
	}

	@Override
	public int compareTo(Led o) {
		if (this.v > o.v) {
			return 1;
		} else {
			return -1;
		}
	}
}
