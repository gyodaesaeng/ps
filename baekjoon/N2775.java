import java.io.*;

public class N2775 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			System.out.println(peopleNumber(a, b));
		}
	}

	public static int peopleNumber(int a, int b) {
		int n = 0;
		if (a == 0) {
			n = b;
		} else {
			for (int i = 1; i <= b; i++) {
				n += peopleNumber(a - 1, i);
			}
		}
		return n;
	}
}