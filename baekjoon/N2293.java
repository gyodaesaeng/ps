import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N2293 {
	static int n, k;
	static ArrayList<Integer> value;
	static int[][] number;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(getNumber(k, value.size() - 1));
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		number = new int[k + 1][n];
		value = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			value.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(value);
	}

	static int getNumber(int k, int maxIndex) {
		if (number[k][maxIndex] != 0) {
			if (number[k][maxIndex] == -1) {
				return 0;
			}
			return number[k][maxIndex];
		}
		if (maxIndex == 0) {
			if (k % value.get(maxIndex) == 0) {
				number[k][maxIndex] = 1;
				return 1;
			} else {
				number[k][maxIndex] = -1;
				return 0;
			}
		}
		int sum = 0;
		for (int i = 0; i <= (int) k / value.get(maxIndex); i++) {
			sum += getNumber(k - (value.get(maxIndex) * i), maxIndex - 1);
		}
		if (sum == 0) {
			number[k][maxIndex] = -1;
			return 0;
		}
		return number[k][maxIndex] = sum;
	}
}