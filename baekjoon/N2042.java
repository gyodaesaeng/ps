import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2042 {
	static int n, m, k;
	static long[] list, sum;
	static In[] in;

	public static void main(String[] args) throws IOException {
		input();
		output(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = Long.parseLong(br.readLine());
		}
		in = new In[m + k];
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			in[i] = new In(st.nextToken().equals("1"), Integer.parseInt(st.nextToken()),
					Long.parseLong(st.nextToken()));
		}
	}

	static long[] solve() {
		long[] ans = new long[k];
		sum = new long[n + 1];
		int index = 0;
		for (int i = 1; i <= n; i++) {
			int num = i;
			while (num <= n) {
				sum[num] += list[i];
				num += (num & -num);
			}
		}
		for (In i : in) {
			if (i.a) {
				long d = i.c - list[i.b];
				list[i.b] = i.c;
				int num = i.b;
				while (num <= n) {
					sum[num] += d;
					num += (num & -num);
				}
			} else {
				int num = (int) i.c;
				while (num > 0) {
					ans[index] += sum[num];
					num -= (num & -num);
				}
				num = (int) i.b - 1;
				while (num > 0) {
					ans[index] -= sum[num];
					num -= (num & -num);
				}
				index++;
			}
		}
		return ans;
	}

	static void output(long[] ans) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (long i : ans) {
			bw.write(i + "\n");
		}
		bw.flush();
	}
}

class In {
	boolean a;
	int b;
	long c;

	In(boolean a, int b, long c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}