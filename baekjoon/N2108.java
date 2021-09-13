import java.io.*;
import java.util.Arrays;

public class N2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nList = new int[n];
		for (int i = 0; i < n; i++) {
			nList[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nList);
		int sum = 0;
		int contCount = 0;
		int maxContCount = -1;
		int maxContCountIndex = 0;
		int firstMax = 0;
		for (int i = 0; i < n; i++) {
			sum += nList[i];
			if (i > 0) {
				if (nList[i - 1] == nList[i]) {
					contCount++;
				} else {
					contCount = 0;
				}
			}
			if (contCount == maxContCount && firstMax == 1) {
				maxContCountIndex = i;
				firstMax = 2;
			}
			if (contCount > maxContCount) {
				firstMax = 1;
				maxContCountIndex = i;
				maxContCount = contCount;
			}
		}
		System.out.println(Math.round((float) sum / n));
		System.out.println(nList[(int) (n / 2)]);
		System.out.println(nList[maxContCountIndex]);
		System.out.println(nList[n - 1] - nList[0]);
	}
}
