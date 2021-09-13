import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2447 {
	static boolean[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		star = new boolean[n][n];
		writeStar(0, 0, n);
		output(n);
	}

	static void writeStar(int left, int top, int length) {
		if (length == 1) {
			star[left][top] = true;
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				writeStar(left + (i * length / 3), top + (j * length / 3), length / 3);
			}
		}
	}

	static void output(int n) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (star[i][j]) {
					bw.write('*');
				} else {
					bw.write(' ');
				}
			}
			bw.newLine();
		}
		bw.flush();
	}
}
