import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1039 {
	static int n, m, k;
	static int[] ten;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		sc.close();
		System.out.print(solve());
	}

	static int solve() {
		boolean[] check = new boolean[10 * n];
		check[0] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		int max = -1;
		m = (int) (Math.log(n) / Math.log(10));
		ten = new int[m + 2];
		ten[0] = 1;
		for (int i = 1; i < m + 2; i++) {
			ten[i] = ten[i - 1] * 10;
		}
		q.offer(n * 10 + k - 1);
		while (!q.isEmpty()) {
			int peek = q.poll();
			int np = peek / 10;
			int kp = peek % 10;
			for (int i = 0; i < m; i++) {
				for (int j = i + 1; j <= m; j++) {
					int temp = swap(np, j, i);
					if (!check[temp]) {
						check[temp] = true;
						if (kp > 0) {
							q.offer(temp * 10 + kp - 1);
						}
					}
					if (kp % 2 == 0 && temp > 0) {
						max = Math.max(max, temp);
					}
				}
			}
		}
		return max;
	}

	static int swap(int n, int a, int b) {
		int na = (n % ten[a + 1]) / ten[a];
		int nb = (n % ten[b + 1]) / ten[b];
		if (a == m && nb == 0) {
			return 0;
		}
		return n + (na * (ten[b] - ten[a])) + (nb * (ten[a] - ten[b]));
	}
}
