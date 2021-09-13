import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N2309 {
	public static void main(String[] args) throws IOException {
		output(solve(input()));
	}

	static int[] input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = new int[9];
		for (int i = 0; i < 9; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}
		return n;
	}

	static int[] solve(int[] n) {
		int sum = 0;
		for (int i : n) {
			sum += i;
		}
		int[] fake = new int[2];
		boolean find = false;
		for (int i = 0; i < 9; i++) {
			sum -= n[i];
			for (int j = i + 1; j < 9; j++) {
				if (sum - n[j] == 100) {
					fake[0] = i;
					fake[1] = j;
					find = true;
					break;
				}
			}
			sum += n[i];
			if (find) {
				break;
			}
		}
		int[] answer = new int[7];
		int index = 0;
		for (int i = 0; i < 9; i++) {
			if (i != fake[0] && i != fake[1]) {
				answer[index++] = n[i];
			}
		}
		Arrays.sort(answer);
		return answer;
	}

	static void output(int[] n) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i : n) {
			bw.write(i + "\n");
		}
		bw.flush();
	}
}
