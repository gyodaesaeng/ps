import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N15953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ans = 0;
			if (a > 0) {
				if (a < 22) {
					ans += 10;
				}
				if (a < 16) {
					ans += 20;
				}
				if (a < 11) {
					ans += 20;
				}
				if (a < 7) {
					ans += 150;
				}
				if (a < 4) {
					ans += 100;
				}
				if (a < 2) {
					ans += 200;
				}
			}
			if (b > 0) {
				if (b < 32) {
					ans += 32;
				}
				if (b < 16) {
					ans += 32;
				}
				if (b < 8) {
					ans += 64;
				}
				if (b < 4) {
					ans += 128;
				}
				if (b < 2) {
					ans += 256;
				}
			}
			System.out.println(ans * 10000);
		}
	}
}
