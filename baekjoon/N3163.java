import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3163 {
	static BufferedReader br;
	static int n, l, k;
	static int[] a, p;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			input();
			System.out.println(solve());
		}
	}

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n];
		p = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			a[i] = Integer.parseInt(st.nextToken());
		}
	}

	static int solve() {
		int answer = 0;
		ListStack right = new ListStack();
		ListQueue left = new ListQueue();
		ListDeque listDeque = new ListDeque();
		for (int i = 0; i < n; i++) {
			listDeque.pushBack(a[i]);
			if (a[i] > 0) {
				right.push(l - p[i]);
			} else {
				left.push(p[i]);
			}
		}
		for (int i = 1; i < k; i++) {
			if (right.empty()) {
				left.pop();
				listDeque.popFront();
				continue;
			}
			if (left.empty()) {
				right.pop();
				listDeque.popBack();
				continue;
			}
			if ((int) right.peek() == (int) left.peek()) {
				if ((int) listDeque.peekFront() < (int) listDeque.peekBack()) {
					left.pop();
					listDeque.popFront();
				} else {
					right.pop();
					listDeque.popBack();
				}
			} else {
				if ((int) right.peek() > (int) left.peek()) {
					left.pop();
					listDeque.popFront();
				} else {
					right.pop();
					listDeque.popBack();
				}
			}
		}
		if (right.empty()) {
			left.pop();
			return (int) listDeque.popFront();
		}
		if (left.empty()) {
			right.pop();
			return (int) listDeque.popBack();
		}
		if ((int) right.peek() == (int) left.peek()) {
			if ((int) listDeque.peekFront() < (int) listDeque.peekBack()) {
				left.pop();
				answer = (int) listDeque.popFront();
			} else {
				right.pop();
				answer = (int) listDeque.popBack();
			}
		} else {
			if ((int) right.peek() > (int) left.peek()) {
				left.pop();
				answer = (int) listDeque.popFront();
			} else {
				right.pop();
				answer = (int) listDeque.popBack();
			}
		}
		return answer;
	}

	static class ListQueue {

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

	static class ListDeque {
		private class Node {
			private Object data;
			private Node prevNode;
			private Node nextNode;

			Node(Object data) {
				this.data = data;
				this.prevNode = null;
				this.nextNode = null;
			}
		}

		private Node front;
		private Node back;
		private int size;

		public ListDeque() {
			front = null;
			back = null;
			size = 0;
		}

		public boolean empty() {
			return (front == null);
		}

		public void pushFront(Object data) {
			Node node = new Node(data);
			if (empty()) {
				front = node;
				back = node;
			} else {
				front.prevNode = node;
				node.nextNode = front;
				front = node;
			}
			size++;
		}

		public void pushBack(Object data) {
			Node node = new Node(data);
			if (empty()) {
				front = node;
				back = node;
			} else {
				back.nextNode = node;
				node.prevNode = back;
				back = node;
			}
			size++;
		}

		public Object popFront() {
			Object data = front.data;
			front = front.nextNode;
			if (front == null) {
				back = null;
			} else {
				front.prevNode = null;
			}
			size--;
			return data;
		}

		public Object popBack() {
			Object data = back.data;
			back = back.prevNode;
			if (back == null) {
				front = null;
			} else {
				back.nextNode = null;
			}
			size--;
			return data;
		}

		public Object peekFront() {
			return front.data;
		}

		public Object peekBack() {
			return back.data;
		}

		public int size() {
			return size;
		}
	}

}
