import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class N9019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] memo = new int[10000];
			Arrays.fill(memo, -1);
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(a);
			memo[a] = 0;
			int peek = a;
			while (peek != b) {
				peek = q.poll();
				int temp = (peek * 2) % 10000;
				if (memo[temp] < 0) {
					memo[temp] = peek * 10 + 1;
					q.offer(temp);
				}
				temp = peek - 1;
				if (temp < 0) {
					temp = 9999;
				}
				if (memo[temp] < 0) {
					memo[temp] = peek * 10 + 2;
					q.offer(temp);
				}
				if (peek > 0) {
					temp = (peek / 1000) + (peek % 1000) * 10;
					if (memo[temp] < 0) {
						memo[temp] = peek * 10 + 3;
						q.offer(temp);
					}
					temp = (peek / 10) + (peek % 10) * 1000;
					if (memo[temp] < 0) {
						memo[temp] = peek * 10 + 4;
						q.offer(temp);
					}
				}
			}
			Stack<Character> s = new Stack<Character>();
			peek = memo[peek];
			while (peek % 10 > 0) {
				switch (peek % 10) {
				case 1:
					s.push('D');
					break;
				case 2:
					s.push('S');
					break;
				case 3:
					s.push('L');
					break;
				case 4:
					s.push('R');
					break;
				}
				peek = memo[peek / 10];
			}
			while (!s.isEmpty()) {
				bw.write(s.pop());
			}
			bw.newLine();
			bw.flush();
		}
	}
}
