import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2580 {
	static int[][] map;
	static int n;
	static int[][] blank;

	public static void main(String[] args) throws IOException {
		input();
		output(solve(0, new int[n]));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		blank = new int[81][2];
		n = 0;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					map[i][j] = 10 + n;
					blank[n][0] = i;
					blank[n++][1] = j;
				}
			}
		}
	}

	static int[] solve(int index, int[] number) {
		if (index == n) {
			return number;
		}
		for (int i = 1; i <= 9; i++) {
			if (cS(blank[index][1], blank[index][0], i, number)) {
				int[] temp = new int[n];
				for (int j = 0; j < index; j++) {
					temp[j] = number[j];
				}
				temp[index] = i;
				int[] t = solve(index + 1, temp);
				if (t[0] > 0) {
					return t;
				}
			}
		}
		return new int[1];
	}

	static boolean cS(int x, int y, int n, int[] number) {
		for (int i = 0; i < 9; i++) {
			if (i != y) {
				if (map[i][x] > 9) {
					if (number[map[i][x] - 10] == n) {
						return false;
					}
				}
				if (map[i][x] == n) {
					return false;
				}
			}
			if (i != x) {
				if (map[y][i] > 9) {
					if (number[map[y][i] - 10] == n) {
						return false;
					}
				}
				if (map[y][i] == n) {
					return false;
				}
			}
		}
		int boxX = x / 3;
		int boxY = y / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j != y % 3 || i != x % 3) {
					if (map[j + boxY * 3][i + boxX * 3] > 9) {
						if (number[map[j + boxY * 3][i + boxX * 3] - 10] == n) {
							return false;
						}
					}
					if (map[j + boxY * 3][i + boxX * 3] == n) {
						return false;
					}
				}
			}
		}
		return true;
	}

	static void output(int[] ans) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] > 9) {
					bw.write(ans[map[i][j] - 10] + " ");
				} else {
					bw.write(map[i][j] + " ");
				}
			}
			bw.newLine();
		}
		bw.flush();
	}
}
