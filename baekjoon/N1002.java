import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] input = new int[6];
			for (int j = 0; j < 6; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			System.out.println(solve(input[0], input[1], input[2], input[3], input[4], input[5]));
		}
	}

	static int solve(int x1, int y1, int r1, int x2, int y2, int r2) {
		if (x1 == x2 && y1 == y2 && r1 == r2) {
			return -1;
		}
		if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) == (r1 - r2) * (r1 - r2)
				|| (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) == (r1 + r2) * (r1 + r2)) {
			return 1;
		}
		if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) > (r1 - r2) * (r1 - r2)
				&& (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < (r1 + r2) * (r1 + r2)) {
			return 2;
		}
		return 0;
	}
}
