import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N14748 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(br.readLine());
		int c = 1;
		boolean comma = true;
		boolean error = false;
		ListStack listStack = new ListStack();
		String g = br.readLine();
		g = g.replace(" ", "");
		int i = 0;
		if (g.length() == 0) {
			c++;
		}
		while (g.length() > i) {
			switch (g.charAt(i++)) {
			case 'S':
				if (comma) {
					comma = false;
				} else {
					error = true;
				}
				break;
			case ',':
				if (comma) {
					error = true;
				} else {
					comma = true;
				}
				break;
			case 'L':
				c += w - 1;
			case 'B':
				c++;
				if (!comma) {
					error = true;
					break;
				}
				switch (g.charAt(i++)) {
				case '[':
					listStack.push(true);
					break;
				case '(':
					listStack.push(false);
					break;
				default:
					error = true;
					break;
				}
				break;
			case ']':
				if (comma == true) {
					if (i > 1) {
						if (g.charAt(i - 2) != '[') {
							error = true;
							break;
						} else {
							if (g.charAt(i - 3) == 'L') {
								c -= w;
							}
						}
					} else {

						error = true;
						break;
					}
				}
				if (!listStack.empty()) {
					if (!(boolean) listStack.pop()) {
						error = true;
					}
				} else {
					error = true;
				}
				break;
			case ')':
				if (comma == true) {
					if (i > 1) {
						if (g.charAt(i - 2) != '(') {
							error = true;
							break;
						} else {
							if (g.charAt(i - 3) == 'L') {
								c -= w;
							}
						}
					} else {

						error = true;
						break;
					}
				}
				if (!listStack.empty()) {
					if ((boolean) listStack.pop()) {
						error = true;
					}
				} else {
					error = true;
				}
				break;
			default:
				error = true;
				break;
			}
			if (error) {
				break;
			}
		}
		if (error || !listStack.empty() || comma) {
			System.out.println(-1);
		} else {
			System.out.println(c);
		}
	}

	static class ListStack {
		private Node top;

		private class Node {

			private Object data;
			private Node nextNode;

			Node(Object data) {
				this.data = data;
				this.nextNode = null;
			}
		}

		public ListStack() {
			this.top = null;
		}

		public boolean empty() {
			return (top == null);
		}

		public void push(Object item) {

			Node newNode = new Node(item);
			newNode.nextNode = top;
			top = newNode;

		}

		public Object peek() {
			if (empty())
				throw new ArrayIndexOutOfBoundsException();
			return top.data;
		}

		public Object pop() {

			Object item = peek();
			top = top.nextNode;
			return item;
		}

	}
}
