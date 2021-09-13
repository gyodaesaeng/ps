import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class N1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		N1021.ListQueue listDeque = new N1021().new ListQueue();
		N1021.ListQueue listQueue = new N1021().new ListQueue();
		for (int i = 1; i <= n; i++) {
			listDeque.push(i);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			listQueue.push(Integer.parseInt(st.nextToken()));
		}
		int answer = 0;
		while (!listQueue.empty()) {
			int length;
			for (length = 0; (int) listQueue.peek() != (int) listDeque.peek(); length++) {
				listDeque.push(listDeque.pop());
			}
			if (length > listDeque.size() / 2) {
				length = listDeque.size() - length;
			}
			listQueue.pop();
			listDeque.pop();
			answer += length;
		}
		System.out.println(answer);
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
