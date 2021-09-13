
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		int last = queue.poll();
		while (!queue.isEmpty()) {
			queue.add(queue.poll());
			last = queue.poll();
		}
		System.out.println(last);
	}
}
