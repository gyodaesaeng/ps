import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2156 {
	static int n;
	static int[] wineValue;
	static int[][] maxValue;

	public static void main(String[] args) throws IOException {
		input();
		int max = getValue(n - 1, 0);
		if (n > 1) {
			max = Math.max(max, getValue(n - 2, 0));
		}
		System.out.println(max);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		wineValue = new int[n];
		maxValue = new int[n][2];
		for (int i = 0; i < n; i++) {
			wineValue[i] = Integer.parseInt(br.readLine());
			maxValue[i][0] = -1;
			maxValue[i][1] = -1;
		}
	}

	static int getValue(int n, int stack) {
		if (maxValue[n][stack] > -1) {
			return maxValue[n][stack];
		}
		if (n == 0) {
			return maxValue[n][stack] = wineValue[0];
		}
		if (n == 1) {
			if (stack == 0) {
				return maxValue[n][stack] = wineValue[0] + wineValue[1];
			} else {
				return maxValue[n][stack] = wineValue[1];
			}
		}
		if (stack == 0) {
			return maxValue[n][stack] = Math.max(getValue(n - 1, 1), getValue(n - 2, 0)) + wineValue[n];
		}
		if (n > 2) {
			return maxValue[n][stack] = Math.max(getValue(n - 2, 0), getValue(n - 3, 0)) + wineValue[n];
		}
		return maxValue[n][stack] = getValue(n - 2, 0) + wineValue[n];
	}
}
