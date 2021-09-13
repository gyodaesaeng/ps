import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1992 {
	static int n;
	static boolean[][] media;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve(0, 0, n, n));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		media = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				media[i][j] = (temp.charAt(j) == '1');
			}
		}
	}

	static String solve(int top, int left, int bottom, int right) {
		String answer = "";
		boolean same = true;
		for (int i = top; i < bottom; i++) {
			for (int j = left; j < right; j++) {
				if (media[top][left] != media[i][j]) {
					same = false;
					break;
				}
			}
			if (!same) {
				break;
			}
		}
		if (same) {
			if (media[top][left]) {
				answer = "1";
			} else {
				answer = "0";
			}
		} else {
			answer += '(';
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					answer += solve(top + i * (bottom - top) / 2, left + j * (right - left) / 2,
							top + (i + 1) * (bottom - top) / 2, left + (j + 1) * (right - left) / 2);
				}
			}
			answer += ')';
		}
		return answer;
	}
}
