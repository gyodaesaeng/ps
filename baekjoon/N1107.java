import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1107 {
	static boolean[] work;
	static String number;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(findNumber());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		number = br.readLine();
		work = new boolean[10];
		for (int i = 0; i < 10; i++) {
			work[i] = true;
		}
		int m = Integer.parseInt(br.readLine());
		if (m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				work[Integer.parseInt(st.nextToken())] = false;
			}
		}
	}

	static int findNumber() {
		int n = Integer.parseInt(number);
		int m = Math.abs(n - 100);
		int min = m;
		for (int i = 0; i < m; i++) {
			if (n - i >= 0) {
				String temp = Integer.toString(n - i);
				boolean can = true;
				for (int j = 0; j < temp.length(); j++) {
					if (!work[temp.charAt(j) - '0']) {
						can = false;
						break;
					}
				}
				if (can) {
					if (temp.length() + i < min) {
						min = temp.length() + i;
					}
				}
			}
			String temp = Integer.toString(n + i);
			boolean can = true;
			for (int j = 0; j < temp.length(); j++) {
				if (!work[temp.charAt(j) - '0']) {
					can = false;
					break;
				}
			}
			if (can) {
				if (temp.length() + i < min) {
					min = temp.length() + i;
				}
			}
		}
		return min;
	}
}
