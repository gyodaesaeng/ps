import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2579 {
	static int[] stair;
	static int n;
	static int[][] score;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(Math.max(getScore(n - 1, 0), getScore(n - 1, 1)));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stair = new int[n];
		score = new int[n][2];
		for (int i = 0; i < n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
	}

	static int getScore(int n, int k) {
		if (n < 0) {
			return 0;
		}
		if (score[n][k] > 0) {
			return score[n][k];
		}
		if (k == 1) {
			score[n][k] = stair[n] + getScore(n - 2, 0);
		} else {
			score[n][k] = stair[n] + Math.max(getScore(n - 1, 1), getScore(n - 2, 0));
		}
		return score[n][k];
	}
}
