import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9252 {
	static String a, b;
	static String[][] lcs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();
		lcs = new String[a.length()][b.length()];
		String answer = getLcs(0, 0);
		if (answer == null) {
			System.out.println(0);
			System.out.println("");
		} else {
			System.out.println(answer.length());
			System.out.println(answer);
		}
	}

	static String getLcs(int aIndex, int bIndex) {
		if (aIndex == a.length() || bIndex == b.length()) {
			return "";
		}
		if (lcs[aIndex][bIndex] != null) {
			return lcs[aIndex][bIndex];
		}
		if (a.charAt(aIndex) == b.charAt(bIndex)) {
			return lcs[aIndex][bIndex] = a.charAt(aIndex) + getLcs(aIndex + 1, bIndex + 1);
		}
		if (getLcs(aIndex + 1, bIndex).length() > getLcs(aIndex, bIndex + 1).length()) {
			return lcs[aIndex][bIndex] = getLcs(aIndex + 1, bIndex);
		}
		return lcs[aIndex][bIndex] = getLcs(aIndex, bIndex + 1);
	}
}
