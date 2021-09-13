import java.io.*;
import java.util.*;

public class N10871 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int temp;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			temp = sc.nextInt();
			if (temp < x) {
				bw.write(temp + " ");
			}
		}
		sc.close();
		bw.flush();
	}
}
