import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			ListDeque listDeque = new ListDeque();
			for (int j = 0; j < n; j++) {
				listDeque.pushBack(Integer.parseInt(st.nextToken()));
			}
			boolean forward = true;
			boolean error = false;
			int k = p.length();
			for (int j = 0; j < k; j++) {
				if (p.charAt(j) == 'R') {
					forward = !forward;
				} else {
					if (listDeque.empty()) {
						error = true;
						break;
					} else {
						if (forward) {
							listDeque.popFront();
						} else {
							listDeque.popBack();
						}
					}
				}
			}
			if (error) {
				bw.write("error");
			} else {
				bw.write('[');
				k = listDeque.size();
				if (forward) {
					for (int j = 0; j < k; j++) {
						bw.write(Integer.toString((int) listDeque.popFront()));
						if (j < k - 1) {
							bw.write(',');
						}
					}
				} else {
					for (int j = 0; j < k; j++) {
						bw.write(Integer.toString((int) listDeque.popBack()));
						if (j < k - 1) {
							bw.write(',');
						}
					}
				}
				bw.write(']');
			}
			bw.newLine();
		}
		bw.flush();
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
