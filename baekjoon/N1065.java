import java.util.*;

public class N1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp;
		int theNumber = 0;
		sc.close();
		for (int i = 1; i <= n; i++) {
			if (i / 10 > 0) {
				if (i / 100 >= 1) {
					temp = i / 100;
					if (temp - ((i % 100) / 10) == (((i % 100) / 10) - i % 10)) {
						theNumber++;
					}
				} else {
					theNumber++;
				}
			} else {
				theNumber++;
			}
		}
		System.out.println(theNumber);
	}
}
