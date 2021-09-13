import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = br.readLine();
			if (s.charAt(0) == '.') {
				break;
			}
			if (balance(s)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	static boolean balance(String s) {
		Stack<Boolean> stack = new Stack<Boolean>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
				stack.add(true);
				break;
			case '[':
				stack.add(false);
				break;
			case ')':
				if (stack.empty()) {
					return false;
				}
				if (!stack.peek()) {
					return false;
				}
				stack.pop();
				break;
			case ']':
				if (stack.empty()) {
					return false;
				}
				if (stack.peek()) {
					return false;
				}
				stack.pop();
				break;
			}
		}
		if (!stack.empty()) {
			return false;
		}
		return true;
	}
}
