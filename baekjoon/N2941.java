import java.util.*;

public class N2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		int minus = 0;
		for (int i = 1; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '=':
				if (str.charAt(i - 1) == 'c' || str.charAt(i - 1) == 's' || str.charAt(i - 1) == 'z') {
					minus++;
					if (str.charAt(i - 1) == 'z' && i > 1) {
						if (str.charAt(i - 2) == 'd') {
							minus++;
						}
					}
				}
				break;
			case '-':
				if (str.charAt(i - 1) == 'c' || str.charAt(i - 1) == 'd') {
					minus++;
				}
				break;
			case 'j':
				if (str.charAt(i - 1) == 'l' || str.charAt(i - 1) == 'n') {
					minus++;
				}
				break;
			}
		}
		System.out.println(str.length() - minus);
	}
}
