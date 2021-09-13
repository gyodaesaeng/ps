import java.util.*;

public class N10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		int[] theNumber = new int[26];
		for (int i = 0; i < 26; i++) {
			theNumber[i] = -1;
		}
		for (int i = 0; i < str.length(); i++) {
			if (theNumber[str.charAt(i) - 'a'] == -1) {
				theNumber[str.charAt(i) - 'a'] = i;
			}
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(theNumber[i] + " ");
		}
	}
}
