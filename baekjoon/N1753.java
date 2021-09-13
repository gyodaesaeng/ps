import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1753 {
	static int v, e, k;
	static int[][] in;
	static int[] min;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		in = new int[e][3];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				in[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		min = new int[v + 1];
		Arrays.fill(min, Integer.MAX_VALUE);
		ArrayList<Node>[] arr = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			arr[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < e; i++) {
			arr[in[i][0]].add(new Node(in[i][1], in[i][2]));
		}
		in = null;
		MinHeap heap = new MinHeap(e + 1);
		heap.insert(new Node(k, 0));
		while (heap.index > 0) {
			int now = heap.peek().end;
			int len = heap.peek().len;
			if (len <= min[now]) {
				min[now] = len;
				for (Node node : arr[now]) {
					if (node.len + len < min[node.end]) {
						heap.insert(new Node(node.end, node.len + len));
					}
				}
			}
			heap.remove();
		}

	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= v; i++) {
			if (min[i] < Integer.MAX_VALUE) {
				bw.write(min[i] + "\n");
			} else {
				bw.write("INF\n");
			}
		}
		bw.flush();
	}

	static class Node {
		int end, len;

		Node(int e, int l) {
			end = e;
			len = l;
		}
	}

	static class MinHeap {
		Node[] heap;
		Node max;
		int index;

		MinHeap(int n) {
			index = 0;
			heap = new Node[n + 1];
			max = new Node(0, Integer.MAX_VALUE);
			Arrays.fill(heap, max);
		}

		void insert(Node node) {
			heap[++index] = node;
			for (int i = index; i > 1; i /= 2) {
				if (heap[i].len < heap[i / 2].len) {
					swap(i, i / 2);
				}
			}
		}

		void remove() {
			if (index == 0) {
				return;
			}
			heap[1] = heap[index];
			heap[index--] = max;
			for (int i = 1; i * 2 <= index;) {
				if (heap[i].len < heap[i * 2].len && heap[i].len < heap[i * 2 + 1].len) {
					break;
				} else {
					if (heap[i * 2].len < heap[i * 2 + 1].len) {
						swap(i, i * 2);
						i *= 2;
					} else {
						swap(i, i * 2 + 1);
						i = i * 2 + 1;
					}
				}
			}
		}

		Node peek() {
			return heap[1];
		}

		void swap(int a, int b) {
			Node temp = heap[a];
			heap[a] = heap[b];
			heap[b] = temp;
		}
	}
}
