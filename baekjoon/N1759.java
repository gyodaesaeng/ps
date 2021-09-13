import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1759 {
	static int l, c;
	static char[] in;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		in = new char[c];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			in[i] = st.nextToken().charAt(0);
		}
	}

	static void solve() throws IOException {
		Arrays.sort(in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bt("", 0, 0, 0, 0);
		bw.flush();
	}

	static void bt(String last, int i, int j, int con, int vow) throws IOException {
		if (j == l) {
			if (con > 1 && vow > 0) {
				bw.write(last + "\n");
			}
			return;
		}
		for (int k = i; k <= c + j - l; k++) {
			if (in[k] == 'a' || in[k] == 'i' || in[k] == 'e' || in[k] == 'o' || in[k] == 'u') {
				bt(last + in[k], k + 1, j + 1, con, vow + 1);
			} else {
				bt(last + in[k], k + 1, j + 1, con + 1, vow);
			}
		}
	}
}
