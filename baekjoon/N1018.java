import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] board = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = temp.charAt(j) == 'W';
			}
		}
		int min = n * m;
		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				int temp1 = 0, temp2 = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if (((k + l) % 2 == 0 && board[i + k][j + l]) || ((k + l) % 2 == 1 && !board[i + k][j + l])) {
							temp1++;
						} else {
							temp2++;
						}
					}
				}
				temp1 = Math.min(temp1, temp2);
				if (temp1 < min) {
					min = temp1;
				}
			}
		}
		System.out.println(min);
	}
}
