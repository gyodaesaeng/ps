import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10775 {
	static int g, p;
	static int[] in, union;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		g = Integer.parseInt(br.readLine());
		p = Integer.parseInt(br.readLine());
		in = new int[p];
		for (int i = 0; i < p; i++) {
			in[i] = Integer.parseInt(br.readLine());
		}
	}

	static int solve() {
		union = new int[g + 1];
		for (int i = 0; i <= g; i++) {
			union[i] = i;
		}
		for (int i = 0; i < p; i++) {
			if (find(in[i]) == 0) {
				return i;
			}
			union(in[i]);
		}
		return p;
	}

	static int find(int a) {
		if (a == union[a]) {
			return a;
		}
		return union[a] = find(union[a]);
	}

	static void union(int a) {
		a = find(a);
		union[a] = find(a - 1);
	}
}
