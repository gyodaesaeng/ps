import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		int n = sc.nextInt();
		sc.close();
		while (n > 0) {
			numberList.add(n % 10);
			n /= 10;
		}
		Collections.sort(numberList);
		for (int i = numberList.size() - 1; i >= 0; i--) {
			System.out.print(numberList.get(i));
		}
	}
}
