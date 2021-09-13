import java.util.Scanner;

public class N1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		sc.close();
		int[] numberCount = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < N.length(); i++) {
			if (N.charAt(i) == '9') {
				numberCount[6]++;
			} else {
				numberCount[N.charAt(i) - '0']++;
			}
		}
		numberCount[6] = (numberCount[6] / 2) + (numberCount[6] % 2);
		int max = 0;
		for (int i = 0; i < 9; i++) {
			if (max < numberCount[i]) {
				max = numberCount[i];
			}
		}
		System.out.println(max);
	}
}
