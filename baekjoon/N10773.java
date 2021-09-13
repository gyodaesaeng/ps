import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N10773 {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp == 0) {
				stack.pop();
			} else {
				stack.add(temp);
			}
		}
		int ans = 0;
		while (!stack.empty()) {
			ans += stack.pop();
		}
		System.out.println(ans);
	}
}
