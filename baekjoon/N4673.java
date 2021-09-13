import java.util.*;

public class N4673 {
	public static void main(String[] args) {
		int[] notSelfNumber = new int[10000];
		for (int i = 1; i < 10000; i++) {
			notSelfNumber[i - 1] = d(i);
		}
		Arrays.sort(notSelfNumber);
		int index = 0;
		for (int i = 1; i <= 10000; i++) {
			while (notSelfNumber[index] == notSelfNumber[index + 1]) {
				index++;
			}
			if (notSelfNumber[index] < i) {
				if (notSelfNumber[index + 1] > i) {
					System.out.println(i);
				} else {
					index++;
				}
			}
		}
	}

	public static int d(int n) {
		int m = n;
		m += n / 1000;
		n = n % 1000;
		m += n / 100;
		n = n % 100;
		m += n / 10;
		m += n % 10;
		return m;
	}
}
