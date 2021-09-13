import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6549 {
	static long[] in;
	static int[] tree;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			}
			in = new long[n + 1];
			for (int i = 0; i < n; i++) {
				in[i] = Long.parseLong(st.nextToken());
			}
			in[n] = Long.MAX_VALUE;
			tree = new int[(int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1)];
			init(1, 0, n - 1);
			System.out.println(getMax(0, n - 1));
		}
	}

	static int init(int index, int start, int end) {
		if (start == end) {
			return tree[index] = start;
		} else {
			int left = init(index * 2, start, (start + end) / 2);
			int right = init(index * 2 + 1, (start + end) / 2 + 1, end);
			if (in[left] > in[right]) {
				return tree[index] = right;
			} else {
				return tree[index] = left;
			}
		}
	}

	static long getMax(int start, int end) {
		if (start > end) {
			return 0;
		}
		int mid = getMin(1, 0, n - 1, start, end);
		long max = in[mid] * (end - start + 1);
		max = Math.max(max, Math.max(getMax(start, mid - 1), getMax(mid + 1, end)));
		return max;
	}

	static int getMin(int index, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return n;
		}
		if (left <= start && end <= right) {
			return tree[index];
		}
		int l = getMin(index * 2, start, (start + end) / 2, left, right);
		int r = getMin(index * 2 + 1, (start + end) / 2 + 1, end, left, right);
		if (in[l] > in[r]) {
			return r;
		} else {
			return l;
		}
	}
}
