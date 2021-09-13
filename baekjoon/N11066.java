import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11066 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int k, a;
	static int[] size;
	static int[][] sum;

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			input();
			System.out.println(devide(0, k - 1));
		}
	}

	static void input() throws IOException {
		k = Integer.parseInt(br.readLine());
		size = new int[k];
		sum = new int[k][k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
	}

	static int devide(int left, int right) {
		if (sum[left][right] > 0) {
			return sum[left][right];
		}
		if (left == right) {
			return 0;
		}
		int min = devide(left, left) + devide(left + 1, right);
		for (int i = 1; i < right - left; i++) {
			if (min > devide(left, left + i) + devide(left + i + 1, right)) {
				min = devide(left, left + i) + devide(left + i + 1, right);
			}
		}
		for (int i = left; i <= right; i++) {
			min += size[i];
		}
		return sum[left][right] = min;
	}
}
