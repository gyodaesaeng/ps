import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N2742 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = n; i > 0; i--) {
			bw.write(i + "\n");
		}
		bw.flush();
	}
}
