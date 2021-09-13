import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		ListDeque listDeque = new ListDeque();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_front":
				listDeque.pushFront(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				listDeque.pushBack(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (listDeque.empty()) {
					bw.write("-1");
				} else {
					bw.write(Integer.toString((int) listDeque.popFront()));
				}
				bw.newLine();
				break;
			case "pop_back":
				if (listDeque.empty()) {
					bw.write("-1");
				} else {
					bw.write(Integer.toString((int) listDeque.popBack()));
				}
				bw.newLine();
				break;
			case "size":
				bw.write(Integer.toString(listDeque.size()));
				bw.newLine();
				break;
			case "empty":
				if (listDeque.empty()) {
					bw.write('1');
				} else {
					bw.write('0');
				}
				bw.newLine();
				break;
			case "front":
				if (listDeque.empty()) {
					bw.write("-1");
				} else {
					bw.write(Integer.toString((int) listDeque.peekFront()));
				}
				bw.newLine();
				break;
			case "back":
				if (listDeque.empty()) {
					bw.write("-1");
				} else {
					bw.write(Integer.toString((int) listDeque.peekBack()));
				}
				bw.newLine();
				break;
			}
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
