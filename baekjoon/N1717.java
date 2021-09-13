import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N1717 {
	static int n, m;
	static int[][] in;
	static int[] set;
	static ArrayList<Boolean> out;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		in = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				in[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		set = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			set[i] = i;
		}
		out = new ArrayList<Boolean>();
		for (int i = 0; i < m; i++) {
			if (in[i][0] == 0) {
				if (get(in[i][1]) > get(in[i][2])) {
					set[set[in[i][1]]] = set[in[i][2]];
				} else {
					set[set[in[i][2]]] = set[in[i][1]];
				}
			} else {
				out.add(get(in[i][1]) == get(in[i][2]));
			}
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (boolean b : out) {
			if (b) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}
		bw.flush();
	}

	static int get(int index) {
		if (index == set[index]) {
			return index;
		}
		return set[index] = get(set[index]);
	}
}