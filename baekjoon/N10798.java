import java.util.Scanner;

public class N10798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] in = new String[5];
		for (int i = 0; i < 5; i++) {
			in[i] = sc.nextLine();
		}
		sc.close();
		String out = "";
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (in[j].length() > i) {
					out += in[j].charAt(i);
				}
			}
		}
		System.out.println(out);
	}
}
