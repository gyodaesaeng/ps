import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1931 {
	static int n;
	static Meet[] meets;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		meets = new Meet[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meets[i] = new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(meets);
	}

	static int solve() {
		int ans = 0;
		int e = 0;
		for (int i = 0; i < n; i++) {
			if (meets[i].s >= e) {
				e = meets[i].e;
				ans++;
			}
		}
		return ans;
	}
}

class Meet implements Comparable<Meet> {
	int s, e;

	Meet(int s, int e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Meet o) {
		if (this.e > o.e) {
			return 1;
		} else if (this.e == o.e && this.s > o.s) {
			return 1;
		}
		return -1;
	}
}
