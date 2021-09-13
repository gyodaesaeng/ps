import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9251 {
	static int[][] lcs;
	static String a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();
		lcs = new int[a.length()][b.length()];
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				lcs[i][j] = -1;
			}
		}
		System.out.println(getLcs(a.length() - 1, b.length() - 1));
	}

	static int getLcs(int aIndex, int bIndex) {
		if (lcs[aIndex][bIndex] > -1) {
			return lcs[aIndex][bIndex];
		}
		if (aIndex == 0) {
			int temp = bIndex;
			while (a.charAt(0) != b.charAt(temp)) {
				if (temp == 0) {
					return lcs[aIndex][bIndex] = 0;
				}
				temp--;
			}
			return lcs[aIndex][bIndex] = 1;
		}
		if (bIndex == 0) {
			int temp = aIndex;
			while (a.charAt(temp) != b.charAt(0)) {
				if (temp == 0) {
					return lcs[aIndex][bIndex] = 0;
				}
				temp--;
			}
			return lcs[aIndex][bIndex] = 1;
		}
		if (a.charAt(aIndex) == b.charAt(bIndex)) {
			return lcs[aIndex][bIndex] = getLcs(aIndex - 1, bIndex - 1) + 1;
		}
		return lcs[aIndex][bIndex] = Math.max(getLcs(aIndex - 1, bIndex), getLcs(aIndex, bIndex - 1));
	}
}
