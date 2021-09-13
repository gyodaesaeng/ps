import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class N1655 {
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

	static void output(int[] ans) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i : ans) {
			bw.write(i + "\n");
		}
		bw.flush();
	}

	static int[] solve() {
		int[] ans = new int[n];
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(n, (Integer a, Integer b) -> a < b ? 1 : -1);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, (Integer a, Integer b) -> a > b ? 1 : -1);
		int mid = ans[0] = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] > mid) {
				if (i % 2 == 0) {
					minHeap.add(mid);
					maxHeap.add(a[i]);
					mid = maxHeap.poll();
				} else {
					maxHeap.add(a[i]);
				}
			} else {
				if (i % 2 == 0) {
					minHeap.add(a[i]);
				} else {
					maxHeap.add(mid);
					minHeap.add(a[i]);
					mid = minHeap.poll();
				}
			}
			ans[i] = mid;
		}
		return ans;
	}
}
