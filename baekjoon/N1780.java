import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1780 {
	static int n;
	static int[][] paper;

	public static void main(String[] args) throws IOException {
		input();
		int[] answer = getPaper(0, 0, n, n);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int[] getPaper(int left, int top, int right, int bottom) {
		boolean single = true;
		int[] answer = new int[3];
		for (int i = top; i < bottom; i++) {
			for (int j = left; j < right; j++) {
				if (paper[j][i] != paper[left][top]) {
					single = false;
					break;
				}
			}
		}
		if (single) {
			answer[paper[left][top] + 1] = 1;
		} else {
			int[] temp;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					temp = getPaper(left + (i * (right - left) / 3), top + (j * (bottom - top) / 3),
							left + ((i + 1) * (right - left) / 3), top + ((j + 1) * (bottom - top) / 3));
					answer[0] += temp[0];
					answer[1] += temp[1];
					answer[2] += temp[2];
				}
			}
		}
		return answer;
	}
}
