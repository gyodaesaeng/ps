import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class N2667 {
	static int n;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		input();
		output(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new boolean[n + 2][n + 2];
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= n; j++) {
				map[i][j] = str.charAt(j - 1) == '1';
			}
		}
	}

	static ArrayList<Integer> solve() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j]) {
					list.add(mapping(i, j));
				}
			}
		}
		Collections.sort(list);
		return list;
	}

	static void output(ArrayList<Integer> list) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(list.size() + "\n");
		for (int i : list) {
			bw.write(i + "\n");
		}
		bw.flush();
	}

	static int mapping(int x, int y) {
		if (!map[x][y]) {
			return 0;
		}
		map[x][y] = false;
		return mapping(x - 1, y) + mapping(x + 1, y) + mapping(x, y - 1) + mapping(x, y + 1) + 1;
	}
}
