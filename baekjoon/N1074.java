import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1074 {
	static int r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		System.out.println(findAnswer(0, 0, (int) Math.pow(2, n)));
	}

	static int findAnswer(int top, int left, int n) {
		if (n == 1) {
			return 0;
		}
		int answer = 0;
		n = n / 2;
		if (r - top >= n) {
			answer += n * n * 2;
			top += n;
		}
		if (c - left >= n) {
			answer += n * n;
			left += n;
		}
		return answer + findAnswer(top, left, n);
	}
}
