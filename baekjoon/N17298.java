import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class N17298 {
	static int n;
	static int[] a, b;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		b = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		for (int i = 1; i < n; i++) {
			while (!stack.empty()) {
				if (a[stack.peek()] < a[i]) {
					b[stack.pop()] = a[i];
				} else {
					break;
				}
			}
			stack.add(i);
		}
		while (!stack.empty()) {
			b[stack.pop()] = -1;
		}

	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			bw.write(b[i] + " ");
		}
		bw.flush();
	}
}
