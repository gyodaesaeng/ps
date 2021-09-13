import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				queue.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(queue.poll() + "\n");
				}
				break;
			case "size":
				bw.write(queue.size() + "\n");
				break;
			case "empty":
				if (queue.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
				break;
			case "front":
				if (queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(queue.peek() + "\n");
				}
				break;
			case "back":
				if (queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(queue.peekLast() + "\n");
				}
				break;
			}
		}
		bw.flush();
	}
}
