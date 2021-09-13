import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class N1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int input;
		ListStack listStack = new ListStack();
		ArrayList<Boolean> answer = new ArrayList<Boolean>();
		answer.add(true);// answer[0] true : can;false : cant
		int index = 0;
		listStack.push(index++);
		listStack.push(index++);
		answer.add(true);// answer[i] true : +;false :-
		for (int i = 0; i < n; i++) {
			input = Integer.parseInt(br.readLine());
			while ((int) listStack.peek() < input) {
				listStack.push(index++);
				answer.add(true);
			}
			if ((int) listStack.pop() == input) {
				answer.add(false);
			} else {
				answer.clear();
				answer.add(false);
				break;
			}
		}
		if (answer.get(0)) {
			for (int i = 1; i < answer.size(); i++) {
				if (answer.get(i)) {
					bw.write('+');
				} else {
					bw.write('-');
				}
				bw.newLine();
			}
		} else {
			bw.write("NO");
		}
		bw.flush();
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
