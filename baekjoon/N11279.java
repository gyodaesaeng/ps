import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N11279 {
	static int n;
	static int[] a;

	public static void main(String[] args) throws IOException {
		input();
		output(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
	}

	static int[] solve() {
		int[] ans = new int[n + 1];
		MaxHeap maxHeap = new MaxHeap(n);
		for (int i : a) {
			if (i == 0) {
				ans[++ans[0]] = maxHeap.remove();
			} else {
				maxHeap.insert(i);
			}
		}
		return ans;
	}

	static void output(int[] ans) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= ans[0]; i++) {
			bw.write(ans[i] + "\n");
		}
		bw.flush();
	}
}

class MaxHeap {
	int[] heap;
	int lastIndex;

	MaxHeap(int n) {
		heap = new int[n + 1];
		lastIndex = 0;
	}

	void insert(int v) {
		heap[++lastIndex] = v;
		for (int i = lastIndex; i > 1; i /= 2) {
			if (heap[i / 2] < heap[i]) {
				swap(i / 2, i);
			} else {
				break;
			}
		}
	}

	int remove() {
		if (lastIndex == 0) {
			return 0;
		}
		int ans = heap[1];
		heap[1] = heap[lastIndex];
		heap[lastIndex] = 0;
		for (int i = 1; i * 2 <= lastIndex;) {
			if (heap[i] > heap[i * 2] && heap[i] > heap[i * 2 + 1]) {
				break;
			} else if (heap[i * 2] > heap[i * 2 + 1]) {
				swap(i, i * 2);
				i = i * 2;
			} else {
				swap(i, i * 2 + 1);
				i = i * 2 + 1;
			}
		}
		return ans;
	}

	void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
}