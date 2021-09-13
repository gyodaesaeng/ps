import java.io.*;

public class N1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] theNumber = new int[26];
		for (int i = 0; i < 26; i++) {
			theNumber[0] = 0;
		}
		int temp;
		while (br.ready()) {
			temp = br.read();
			if (temp >= 'a') {
				theNumber[temp - 'a']++;
			} else if (temp >= 'A') {
				theNumber[temp - 'A']++;
			}
		}
		temp = 0;
		boolean overlap = false;
		for (int i = 1; i < 26; i++) {
			if (theNumber[temp] == theNumber[i]) {
				overlap = true;
			} else if (theNumber[temp] < theNumber[i]) {
				overlap = false;
				temp = i;
			}
		}
		if (overlap) {
			System.out.println("?");
		} else {
			char answer = (char) ('A' + temp);
			System.out.println(answer);
		}
	}
}
