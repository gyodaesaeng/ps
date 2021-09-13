import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10799 {
	static String in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		in = br.readLine();
	}

	static int solve() {
		int ans = 0;
		int stack = 0;
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == '(') {
				if (in.charAt(i + 1) == ')') {
					ans += stack;
				} else {
					stack++;
				}
			} else if (in.charAt(i - 1) == ')') {
				ans++;
				stack--;
			}
		}
		return ans;
	}
}
