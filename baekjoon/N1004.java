import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] co = new int[4];
			for (int j = 0; j < 4; j++) {
				co[j] = Integer.parseInt(st.nextToken());
			}
			int n = Integer.parseInt(br.readLine());
			int ans = 0;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				r *= r;
				if ((sq(co[0] - x) + sq(co[1] - y) > r) ^ (sq(co[2] - x) + sq(co[3] - y) > r)) {
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

	static long sq(long n) {
		return n * n;
	}
}
