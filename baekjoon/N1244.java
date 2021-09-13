import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1244 {
	static int n, m;
	static boolean[] status;
	static int[][] students;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		status = new boolean[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			status[i] = st.nextToken().equals("1");
		}
		m = Integer.parseInt(br.readLine());
		students = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			students[i][0] = Integer.parseInt(st.nextToken());
			students[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= n; i++) {
			if (status[i]) {
				bw.write("1 ");
			} else {
				bw.write("0 ");
			}
			if (i % 20 == 0) {
				bw.newLine();
			}
		}
		bw.flush();
	}

	static void solve() {
		for (int[] i : students) {
			if (i[0] == 1) {
				for (int j = i[1]; j <= n; j += i[1]) {
					status[j] = !status[j];
				}
			} else {
				for (int j = 0; i[1] - j > 0 && i[1] + j <= n; j++) {
					if (status[i[1] - j] ^ status[i[1] + j]) {
						break;
					}
					status[i[1] - j] = status[i[1] + j] = !status[i[1] + j];
				}
			}
		}
	}
}
