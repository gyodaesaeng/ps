import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class N12852 {
	static int n, ans;
	static int[] memo, check;
	static ArrayList<Integer> min;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		solve();
		output();
	}

	static void solve() {
		memo = new int[n + 1];
		check = new int[n + 1];
		ans = dp(n);
		min = new ArrayList<Integer>();
		min.add(n);
		int i = n;
		while (i > 1) {
			switch (check[i]) {
			case 1:
				i /= 3;
				min.add(i);
				break;
			case 2:
				i /= 2;
				min.add(i);
				break;
			case 3:
				i -= 1;
				min.add(i);
				break;
			}
		}
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(ans + "\n");
		for (int num : min) {
			bw.write(num + " ");
		}
		bw.flush();
	}

	static int dp(int n) {
		if (n == 1) {
			return 0;
		}
		if (memo[n] > 0) {
			return memo[n];
		}
		int min = Integer.MAX_VALUE;
		if (n % 3 == 0) {
			if (dp(n / 3) < min) {
				min = dp(n / 3);
				check[n] = 1;
			}
		}
		if (n % 2 == 0) {
			if (dp(n / 2) < min) {
				min = dp(n / 2);
				check[n] = 2;
			}
		}
		if (dp(n - 1) < min) {
			min = dp(n - 1);
			check[n] = 3;
		}
		return memo[n] = min + 1;
	}
}
