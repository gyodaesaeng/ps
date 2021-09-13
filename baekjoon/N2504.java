import java.util.Scanner;

public class N2504 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		ListStack listStack = new ListStack();
		listStack.push((int) -1);
		boolean can = true;
		for (int i = 0; i < input.length(); i++) {
			switch (input.charAt(i)) {
			case '(':
				listStack.push((int) 0);
				break;
			case '[':
				listStack.push((int) 1);
				break;
			case ')':
				if ((int) listStack.peek() > 1) {
					int temp = (int) listStack.pop() * 2;
					if ((int) listStack.pop() == 0) {
						if ((int) listStack.peek() > 1) {
							listStack.push((int) listStack.pop() + temp);
						} else {
							listStack.push(temp);
						}
					} else {
						can = false;
					}
				} else {
					if ((int) listStack.pop() == 0) {
						if ((int) listStack.peek() > 1) {
							listStack.push((int) listStack.pop() + 2);
						} else {
							listStack.push((int) 2);
						}
					} else {
						can = false;
					}
				}
				break;
			case ']':
				if ((int) listStack.peek() > 1) {
					int temp = (int) listStack.pop() * 3;
					if ((int) listStack.pop() == 1) {
						if ((int) listStack.peek() > 1) {
							listStack.push((int) listStack.pop() + temp);
						} else {
							listStack.push(temp);
						}
					} else {
						can = false;
					}
				} else {
					if ((int) listStack.pop() == 1) {
						if ((int) listStack.peek() > 1) {
							listStack.push((int) listStack.pop() + 3);
						} else {
							listStack.push((int) 3);
						}
					} else {
						can = false;
					}
				}
				break;
			default:
				can = false;
				break;
			}
			if (can == false) {
				break;
			}
		}
		if (can == true) {
			int answer = (int) listStack.pop();
			if ((int) listStack.pop() == -1) {
				System.out.println(answer);
			} else {
				System.out.println('0');
			}
		} else {
			System.out.println('0');
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
