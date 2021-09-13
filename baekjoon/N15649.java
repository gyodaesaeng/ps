import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N15649 {
	static int n, m;
	static boolean[] last;

	public static void main(String[] args) throws IOException {
		input();
		last = new boolean[n + 1];
		output(solve("", m));
	}

	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.close();
	}

	static void output(String s) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(s);
		bw.flush();
	}

	static String solve(String l, int m) {
		String s = "";
		if (m == 0) {
			return l + "\n";
		}
		for (int i = 1; i <= n; i++) {
			if (!last[i]) {
				last[i] = true;
				s += solve(l + i + " ", m - 1);
				last[i] = false;
			}
		}
		return s;
	}
}
