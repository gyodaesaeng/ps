import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N2116 {
	static int n;
	static Dice[] dices;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dices = new Dice[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] in = new int[6];
			for (int j = 0; j < 6; j++) {
				in[j] = Integer.parseInt(st.nextToken());
			}
			dices[i] = new Dice(in);
		}
	}

	static int solve() {
		int ans = 0;
		for (int i = 1; i < 7; i++) {
			int low = i;
			int sum = 0;
			for (Dice d : dices) {
				sum += d.getMax(low);
				low = d.getTop(low);
			}
			if (sum > ans) {
				ans = sum;
			}
		}
		return ans;
	}
}

class Dice {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	Dice(int[] in) {
		map.put(in[0], in[5]);
		map.put(in[5], in[0]);
		map.put(in[1], in[3]);
		map.put(in[3], in[1]);
		map.put(in[2], in[4]);
		map.put(in[4], in[2]);
	}

	int getMax(int low) {
		int ans = 6;
		while (ans == low || ans == map.get(low)) {
			ans--;
		}
		return ans;
	}

	int getTop(int low) {
		return map.get(low);
	}
}