import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N11729 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String[][][] memo;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new String[n + 1][4][4];
		sc.close();
		bw.write(Integer.toString((int) Math.pow(2, n) - 1));
		bw.newLine();
		bw.write(move(1, 3, 2, n));
		bw.flush();
	}

	static String move(int start, int target, int other, int n) throws IOException {
		if (memo[n][start][target] == null) {
			if (n > 1) {
				memo[n][start][target] = move(start, other, target, n - 1) + start + " " + target + "\n"
						+ move(other, target, start, n - 1);
			} else {
				memo[n][start][target] = start + " " + target + "\n";
			}
		}
		return memo[n][start][target];
	}
}
