import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2263 {
	static int n;
	static int[] inOrder, postOrder;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		input();
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		print(solve(n, 0, 0));
		bw.flush();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		inOrder = new int[n + 1];
		postOrder = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inOrder[Integer.parseInt(st.nextToken())] = i;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
	}

	static Node solve(int length, int inIndex, int postIndex) {
		int top = postOrder[postIndex + length - 1];
		Node topNode = new Node(top);
		int i = inOrder[top] - inIndex;
		if (i > 0) {
			topNode.setChild(solve(i, inIndex, postIndex));
		}
		if (length - i - 1 > 0) {
			topNode.setChild(solve(length - i - 1, inIndex + i + 1, postIndex + i));
		}
		return topNode;
	}

	static void print(Node node) throws IOException {
		bw.write(Integer.toString(node.id) + ' ');
		for (int i = 0; i < 2; i++) {
			if (node.child[i] != null) {
				print(node.child[i]);
			}
		}
	}
}

class Node {
	int id;
	Node parent;
	Node[] child;

	Node(int id) {
		this.id = id;
		parent = null;
		child = new Node[2];
		child[0] = null;
		child[1] = null;
	}

	Node getParent() {
		return parent;
	}

	Node[] getChild() {
		return child;
	}

	void setParent(Node parent) {
		this.parent = parent;
	}

	void setChild(Node child) {
		if (this.child[0] == null) {
			this.child[0] = child;
		} else {
			this.child[1] = child;
		}
	}
}