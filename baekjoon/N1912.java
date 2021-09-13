import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1912 {
	static int[] max, value;
	static int n;

	public static void main(String[] args) throws IOException {
		input();
		int maxMax = getMax(0);
		for (int i = 0; i < n; i++) {
			if (maxMax < getMax(i)) {
				maxMax = getMax(i);
			}
		}
		System.out.println(maxMax);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		value = new int[n];
		max = new int[n + 1];
		for (int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
			max[i] = -1001;
		}
		max[n] = 0;
	}

	static int getMax(int start) {
		if (max[start] > -1001) {
			return max[start];
		}
		if (getMax(start + 1) > 0) {
			return max[start] = value[start] + max[start + 1];
		}
		return max[start] = value[start];
	}
}
