import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class N13913 {
	static int ans;
	static Stack<Integer> path;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		Queue<Integer> q = new LinkedList<Integer>();
		int[] memo = new int[Math.max(n, k) * 4 + 1];
		Arrays.fill(memo, -2);
		q.offer(n);
		memo[n] = -1;
		while (q.peek() != k) {
			int p = q.poll();
			if (p > k) {
				if (memo[p - 1] == -2) {
					memo[p - 1] = p;
					q.offer(p - 1);
				}
				continue;
			}
			if (memo[p + 1] == -2) {
				memo[p + 1] = p;
				q.offer(p + 1);
			}
			if (p > 0) {
				if (memo[p - 1] == -2) {
					memo[p - 1] = p;
					q.offer(p - 1);
				}
				if (memo[p * 2] == -2) {
					memo[p * 2] = p;
					q.offer(p * 2);
				}
			}
		}
		path = new Stack<Integer>();
		ans = -1;
		for (int i = k; i != -1; i = memo[i]) {
			path.push(i);
			ans++;
		}
		output();
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(ans + "\n");
		while (!path.isEmpty()) {
			bw.write(path.pop() + " ");
		}
		bw.flush();
	}
}