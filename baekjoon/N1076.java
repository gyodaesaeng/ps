import java.util.Scanner;

public class N1076 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] color = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
		int[] a = new int[3];
		for (int i = 0; i < 3; i++) {
			String in = sc.nextLine();
			for (int j = 0; j < 10; j++) {
				if (color[j].equals(in)) {
					a[i] = j;
					break;
				}
			}
		}
		sc.close();
		System.out.print((a[0] * 10 + a[1]) * (long) Math.pow(10, a[2]));
	}
}
