import java.util.*;

public class N10039 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp;
		int avr = 0;
		for (int i = 0; i < 5; i++) {
			temp = sc.nextInt();
			if (temp < 40) {
				temp = 40;
			}
			avr += temp;
		}
		sc.close();
		System.out.println((int) avr / 5);
	}
}
