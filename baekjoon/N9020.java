import java.io.*;

public class N9020 {
	public static boolean[] isCompositeNumber = new boolean[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		findCompositeNumber();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int j = n / 2;
			while (true) {
				if (!(isCompositeNumber[j] || isCompositeNumber[n - j])) {
					System.out.println(Integer.toString(n - j) + " " + Integer.toString(j));
					break;
				} else {
					j++;
				}
			}
		}
	}

	public static void findCompositeNumber() {
		isCompositeNumber[1] = true;
		for (int i = 2; i <= 100; i++) {
			int j = i;
			while (i * j <= 10000) {
				isCompositeNumber[i * j++] = true;
			}
		}
	}
}
