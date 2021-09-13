import java.util.*;

public class N2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n *= sc.nextInt();
		n *= sc.nextInt();
		sc.close();
		String str = Integer.toString(n);
		int[] theNumber = new int[10];
		for (int i = 0; i < 10; i++) {
			theNumber[i] = 0;
		}
		for (int i = 0; i < str.length(); i++) {
			theNumber[str.charAt(i) - '0']++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(theNumber[i]);
		}
	}
}
