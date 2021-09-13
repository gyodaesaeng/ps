import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N15650 {
	static int n, m;

	public static void main(String[] args) throws IOException {
		input();
		output(solve("", 0, m));
	}

	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.close();
	}

	static String solve(String l, int last, int m) {
		String s = "";
		if (m == 0) {
			return l + "\n";
		}
		for (int i = last + 1; i <= n; i++) {
			s += solve(l + i + " ", i, m - 1);
		}
		return s;
	}

	static void output(String s) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(s);
		bw.flush();
	}
}
