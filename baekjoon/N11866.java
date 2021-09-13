import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N11866 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		CircleList circleList = new CircleList(n);
		bw.write('<');
		for (int i = 1; i < n; i++) {
			circleList.moveNode(m - 1);
			bw.write(Integer.toString(circleList.popNowNode()) + ", ");
		}
		bw.write(Integer.toString(circleList.popNowNode()) + '>');
		bw.flush();
	}
}

class CircleList {
	private class Node {
		private int data;
		private Node preNode;
		private Node nextNode;

		public Node(int data) {
			this.data = data;
			preNode = null;
			nextNode = null;
		}
	}

	Node nowNode;
	int circleSize;

	public CircleList(int n) {
		circleSize = n;
		nowNode = new Node(1);
		Node firstNode = nowNode;
		for (int i = 2; i <= n; i++) {
			Node node = new Node(i);
			nowNode.nextNode = node;
			node.preNode = nowNode;
			nowNode = node;
		}
		nowNode.nextNode = firstNode;
		firstNode.preNode = nowNode;
		nowNode = firstNode;
	}

	public void moveNode(int length) {
		length %= size();
		for (int i = 0; i < length; i++) {
			nowNode = nowNode.nextNode;
		}
	}

	public int popNowNode() {
		nowNode.preNode.nextNode = nowNode.nextNode;
		nowNode.nextNode.preNode = nowNode.preNode;
		int nodeData = nowNode.data;
		nowNode = nowNode.nextNode;
		circleSize--;
		return nodeData;
	}

	public int size() {
		return circleSize;
	}
}
