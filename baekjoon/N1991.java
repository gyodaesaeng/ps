import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1991 {
	static int n;
	static char[][] tree;
	static String[] out;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new char[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = st.nextToken().charAt(0) - 'A';
			for (int j = 0; j < 2; j++) {
				tree[node][j] = st.nextToken().charAt(0);
			}
		}
	}

	static void solve() {
		out = new String[3];
		out[0] = preOrder(0);
		out[1] = inOrder(0);
		out[2] = postOrder(0);
	}

	static void output() {
		for (String s : out) {
			System.out.println(s);
		}
	}

	static String preOrder(int node) {
		String ans = "";
		ans += (char) (node + 'A');
		for (int i : tree[node]) {
			if (i != '.') {
				ans += preOrder(i - 'A');
			}
		}
		return ans;
	}

	static String inOrder(int node) {
		String ans = "";
		if (tree[node][0] != '.') {
			ans += inOrder(tree[node][0] - 'A');
		}
		ans += (char) (node + 'A');
		if (tree[node][1] != '.') {
			ans += inOrder(tree[node][1] - 'A');
		}
		return ans;
	}

	static String postOrder(int node) {
		String ans = "";
		for (int i : tree[node]) {
			if (i != '.') {
				ans += postOrder(i - 'A');
			}
		}
		ans += (char) (node + 'A');
		return ans;
	}
}
