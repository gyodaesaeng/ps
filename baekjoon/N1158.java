import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N1158 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		int m = sc.nextInt() - 1;
		sc.close();
		N1158.ListQueue listQueue = new N1158().new ListQueue();
		for (int i = 1; i <= n; i++) {
			listQueue.push(i);
		}
		bw.write("<");
		for (int i = n; i > 1; i--) {
			int t = m % i;
			for (int j = 0; j < t; j++) {
				listQueue.push(listQueue.pop());
			}
			bw.write(Integer.toString((int) listQueue.pop()) + ", ");
		}
		bw.write(Integer.toString((int) listQueue.pop()) + ">");
		bw.flush();
	}

	class ListQueue {

		private class Node {
			private Object data;
			private Node nextNode;

			Node(Object data) {
				this.data = data;
				this.nextNode = null;
			}
		}

		private Node front;
		private Node back;

		public ListQueue() {
			this.front = null;
			this.back = null;
		}

		public boolean empty() {
			return (front == null);
		}

		public void push(Object item) {

			Node node = new Node(item);
			node.nextNode = null;

			if (empty()) {

				back = node;
				front = node;

			} else {

				back.nextNode = node;
				back = node;

			}
		}

		public Object peek() {
			if (empty())
				throw new ArrayIndexOutOfBoundsException();
			return front.data;
		}

		public Object pop() {

			Object item = peek();
			front = front.nextNode;

			if (front == null) {
				back = null;
			}

			return item;
		}

		public int size() {
			int n = 0;
			if (!empty()) {
				n++;
				Node nowNode = front;
				while (nowNode != back) {
					nowNode = nowNode.nextNode;
					n++;
				}
			}
			return n;
		}

		public Object front() {
			return front.data;
		}

		public Object back() {
			return back.data;
		}
	}

}
