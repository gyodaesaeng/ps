import java.util.*;

public class N2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int temp = 1;
		int index = 0;
		while (temp < n) {
			temp += ++index * 6;
		}
		System.out.println(index + 1);
	}
}
