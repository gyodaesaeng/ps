import java.io.*;
import java.util.StringTokenizer;

public class N1011 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int length = -Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			int n = 0;
			int m = 0;
			while (length > 0) {
				n++;
				m++;
				length -= n;
				if (length > 0) {
					m++;
					length -= n;
				}
			}
			System.out.println(m);
		}
	}
}
