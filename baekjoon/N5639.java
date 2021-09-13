import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class N5639 {
	static int[][] tree;
	static ArrayList<Integer> in, out;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		in = new ArrayList<Integer>();
		in.add(Integer.parseInt(br.readLine()));
		while (br.ready()) {
			in.add(Integer.parseInt(br.readLine()));
		}
	}

	static void solve() {
		tree = new int[in.size()][5];
		for (int i = 0; i < in.size(); i++) {
			Arrays.fill(tree[i], -1);
		}
		tree[0][3] = Integer.MIN_VALUE;
		tree[0][4] = Integer.MAX_VALUE;
		for (int i = 1; i < in.size(); i++) {
			int parent = i - 1;
			while (tree[parent][3] > in.get(i) || tree[parent][4] < in.get(i)) {
				parent--;
			}
			if (in.get(i) < in.get(parent)) {
				tree[parent][1] = i;
				tree[i][0] = parent;
				tree[i][3] = tree[parent][3];
				tree[i][4] = in.get(parent);
			} else {
				tree[parent][2] = i;
				tree[i][0] = parent;
				tree[i][3] = in.get(parent);
				tree[i][4] = tree[parent][4];
			}
		}
		out = new ArrayList<Integer>();
		postOrder(0);
	}

	static void postOrder(int n) {
		if (tree[n][1] > 0) {
			postOrder(tree[n][1]);
		}
		if (tree[n][2] > 0) {
			postOrder(tree[n][2]);
		}
		out.add(in.get(n));
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i : out) {
			bw.write(i + "\n");
		}
		bw.flush();
	}
}
