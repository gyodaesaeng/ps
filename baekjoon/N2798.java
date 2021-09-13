import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] c = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			sum += c[i];
			for (int j = i + 1; j < n; j++) {
				sum += c[j];
				for (int k = j + 1; k < n; k++) {
					sum += c[k];
					if (sum <= m && sum > max) {
						max = sum;
					}
					sum -= c[k];
				}
				sum -= c[j];
			}
			sum -= c[i];
		}
		System.out.println(max);
	}
}
