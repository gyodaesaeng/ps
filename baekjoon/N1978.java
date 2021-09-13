import java.io.*;

public class N1978 {
	public static boolean[] isCompositeNumber = new boolean[1001];
	public static int n;
	public static int[] inputData;

	public static void main(String[] args) throws IOException {
		findCompositeNumber();
		readInput();
		System.out.println(solve());
	}

	public static void findCompositeNumber() {
		isCompositeNumber[1] = true;
		for (int i = 2; i < 500; i++) {
			int j = i;
			while (i * j <= 1000) {
				isCompositeNumber[i * j++] = true;
			}
		}
	}

	public static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		inputData = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			inputData[i] = Integer.parseInt(input[i]);
		}
	}

	public static int solve() {
		int numberOfPrimeNumber = 0;
		for (int i = 0; i < n; i++) {
			if (!isCompositeNumber[inputData[i]]) {
				numberOfPrimeNumber++;
			}
		}
		return numberOfPrimeNumber;
	}
}
