import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1022 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int[][] map = new int[r2 - r1 + 1][c2 - c1 + 1];
		int max = 0;
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				map[i - r1][j - c1] = get(i, j);
				if (map[i - r1][j - c1] > max) {
					max = map[i - r1][j - c1];
				}
			}
		}
		int n = Integer.toString(max).length();
		for (int i = 0; i < r2 - r1 + 1; i++) {
			for (int j = 0; j < c2 - c1 + 1; j++) {
				String temp = Integer.toString(map[i][j]);
				for (int k = temp.length(); k < n; k++) {
					bw.write(' ');
				}
				bw.write(temp + ' ');
			}
			bw.newLine();
		}
		bw.flush();
	}

	static int get(int r1, int c1) {
		int temp = 0;
		if (r1 > 0) {
			if (c1 > 0) {
				if (r1 >= c1) {
					temp = 1 + (r1 * ((4 * r1) + 4)) - r1 + c1;
				} else {
					temp = 1 + (c1 * ((4 * c1) - 2)) - r1 - c1;
				}
			} else {
				if (r1 > -c1) {
					temp = 1 + (r1 * ((4 * r1) + 2)) + r1 + c1;
				} else {
					temp = 1 + (-c1 * ((4 * -c1) + 2)) + r1 + c1;
				}
			}
		} else {
			if (c1 > 0) {
				if (-r1 > c1) {
					temp = 1 + (-r1 * ((4 * -r1) - 2)) - r1 - c1;
				} else {
					temp = 1 + (c1 * ((4 * c1) - 2)) - r1 - c1;
				}
			} else {
				if (-r1 > -c1) {
					temp = 1 + (-r1 * ((4 * -r1))) + r1 - c1;
				} else {
					temp = 1 + (-c1 * ((4 * -c1))) + r1 - c1;
				}
			}
		}
		return temp;
	}
}
