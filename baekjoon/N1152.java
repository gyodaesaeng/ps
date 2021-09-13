import java.util.*;

public class N1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		int n = 0;
		boolean letter = false;
		for (int i = 0; i < str.length(); i++) {
			if (letter == false && str.charAt(i) != ' ') {
				letter = true;
				n++;
			} else if (str.charAt(i) == ' ') {
				letter = false;
			}
		}
		System.out.println(n);
	}
}
