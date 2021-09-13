import java.util.Scanner;
import java.io.*;

public class N2675 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		int m;
		String str;
		for (int i = 0; i < n; i++) {
			m = sc.nextInt();
			str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < m; k++) {
					bw.write(str.charAt(j));
				}
			}
			bw.newLine();
		}
		sc.close();
		bw.flush();
	}
}
