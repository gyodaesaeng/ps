import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10801 {
	static int[][] in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		in = new int[10][2];
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				in[j][i] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static char solve() {
		char ans;
		int win = 0;
		for (int i = 0; i < 10; i++) {
			if (in[i][0] > in[i][1]) {
				win++;
			} else if (in[i][0] < in[i][1]) {
				win--;
			}
		}
		if (win > 0) {
			ans = 'A';
		} else if (win < 0) {
			ans = 'B';
		} else {
			ans = 'D';
		}
		return ans;
	}
}
