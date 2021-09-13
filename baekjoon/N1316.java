import java.util.*;

public class N1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int theNumber = 0;
		String temp;
		boolean[] alphabet = new boolean[26];
		boolean groupNumber;
		for (int i = 0; i < n; i++) {
			temp = sc.nextLine();
			groupNumber = true;
			for (int j = 0; j < 26; j++) {
				alphabet[j] = false;
			}
			for (int j = 0; j < temp.length(); j++) {
				if (alphabet[temp.charAt(j) - 'a']) {
					if (temp.charAt(j) != temp.charAt(j - 1)) {
						groupNumber = false;
						break;
					}
				} else {
					alphabet[temp.charAt(j) - 'a'] = true;
				}
			}
			if (groupNumber) {
				theNumber++;
			}
		}
		sc.close();
		System.out.println(theNumber);
	}
}
