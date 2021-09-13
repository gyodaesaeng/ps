import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10800 {
	static int n;
	static Ball[] ball;

	public static void main(String[] args) throws IOException {
		input();
		output(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ball = new Ball[n + 1];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ball[i] = new Ball(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
		}
	}

	static void output(int[] ans) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i : ans) {
			bw.write(i + "\n");
		}
		bw.flush();
	}

	static int[] solve() {
		int[] ans = new int[n];
		int[] colorSum = new int[n + 1];
		int[] tempColorSum = new int[n + 1];
		int sum = 0;
		int tempSum = 0;
		Arrays.sort(ball, 0, n);
		ball[n] = new Ball(0, 0, 0);
		for (int i = 0; i < n; i++) {
			ans[ball[i].i] = sum - colorSum[ball[i].c];
			tempSum += ball[i].s;
			tempColorSum[ball[i].c] += ball[i].s;
			if (ball[i].s < ball[i + 1].s) {
				sum += tempSum;
				for (int j = 0; j < n + 1; j++) {
					colorSum[j] += tempColorSum[j];
					tempColorSum[j] = 0;
				}
				tempSum = 0;
			}
		}
		return ans;
	}
}

class Ball implements Comparable<Ball> {
	int c, s, i;

	Ball(int c, int s, int i) {
		this.c = c;
		this.s = s;
		this.i = i;
	}

	@Override
	public int compareTo(Ball o) {
		if (this.s > o.s) {
			return 1;
		} else if (this.s == o.s) {
			return 0;
		}
		return -1;
	}
}