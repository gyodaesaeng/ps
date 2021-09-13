import java.io.*;

public class N4948 {
	public static boolean[] isCompositeNumber;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			findCompositeNumber(n);
			int theNumber = 0;
			for (int i = 0; i < n; i++) {
				if (!isCompositeNumber[i]) {
					theNumber++;
				}
			}
			System.out.println(theNumber);
		}

	}

	public static void findCompositeNumber(int n) {
		isCompositeNumber = new boolean[n];
		for (int i = 2; i <= Math.sqrt(2 * n); i++) {
			int j;
			if ((n + 1) / i > i) {
				if ((n + 1) % i > 0) {
					j = ((n + 1) / i) + 1;
				} else {
					j = (n + 1) / i;
				}
			} else {
				j = i;
			}
			while (i * j <= n) {
				j++;
			}
			while (i * j <= 2 * n) {
				isCompositeNumber[(i * j++) - (n + 1)] = true;
			}
		}
	}
}
