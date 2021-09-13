import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N1149 {
	static ArrayList<Integer> memo = new ArrayList<Integer>();
	static int[][] price;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		price = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
				memo.add(null);
			}
		}
		int min = Math.min(minPrice(n - 1, 0), minPrice(n - 1, 1));
		System.out.println(Math.min(min, minPrice(n - 1, 2)));
	}

	static int minPrice(int n, int lastColor) {
		if (n == 0) {
			return price[0][lastColor];
		}
		if (memo.get((n * 3) + lastColor) == null) {
			memo.set((n * 3) + lastColor, price[n][lastColor]
					+ Math.min(minPrice(n - 1, (lastColor + 1) % 3), minPrice(n - 1, (lastColor + 2) % 3)));
		}
		return memo.get((n * 3) + lastColor);
	}
}
