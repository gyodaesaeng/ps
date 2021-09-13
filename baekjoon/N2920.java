import java.util.*;

public class N2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		int note;
		boolean ascending = true;
		boolean descending = true;
		for (i = 0; i < 8; i++) {
			note = sc.nextInt();
			if (note != i + 1) {
				ascending = false;
			}
			if (note != 8 - i) {
				descending = false;
			}
		}
		sc.close();
		if (ascending) {
			System.out.println("ascending");
		} else {
			if (descending) {
				System.out.println("descending");
			} else {
				System.out.println("mixed");
			}
		}
	}
}
