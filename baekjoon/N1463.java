import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N1463 {
	static int[] time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		time = new int[n + 1];
		System.out.println(getTime(n));
	}

	static int getTime(int n) {
		if (time[n] > 0) {
			return time[n];
		}
		if (n == 1) {
			return 0;
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if (n % 3 == 0) {
			temp.add(getTime(n / 3) + 1);
		}
		if (n % 2 == 0) {
			temp.add(getTime(n / 2) + 1);
		}
		temp.add(getTime(n - 1) + 1);
		Collections.sort(temp);
		time[n] = temp.get(0);
		return time[n];
	}
}
