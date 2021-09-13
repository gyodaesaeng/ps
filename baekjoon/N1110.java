import java.util.*;

public class N1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int i = 0;
		int temp = n;
		while (true) {
			i++;
			temp = (((temp / 10) + (temp % 10)) % 10) + ((temp % 10) * 10);
			if (temp == n) {
				break;
			}
		}
		System.out.print(i);
	}
}
