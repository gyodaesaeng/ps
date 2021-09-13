import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N2437 {
	static int n;
	static ArrayList<Integer> in;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			in.add(Integer.parseInt(st.nextToken()));
		}
	}

	static int solve() {
		Collections.sort(in);
		int sum = 0;
		for (int i : in) {
			if (i <= sum + 1) {
				sum += i;
			} else {
				break;
			}
		}
		return sum + 1;
	}
}
