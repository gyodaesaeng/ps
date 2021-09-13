import java.io.*;
import java.util.StringTokenizer;

public class N10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			int x = ((n - 1) / h) + 1;
			int y = ((n - 1) % h) + 1;
			if (x >= 10) {
				System.out.println(y + "" + x);
			} else {
				System.out.println(y + "0" + x);
			}
		}
	}
}
