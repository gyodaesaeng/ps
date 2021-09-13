import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class N10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (stack.empty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.empty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "top":
				if (stack.empty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
				break;
			}
		}
	}
}
