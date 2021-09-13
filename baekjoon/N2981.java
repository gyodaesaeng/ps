import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class N2981 {
	static int n;
	static ArrayList<Integer> number;

	public static void main(String[] args) throws IOException {
		input();
		int maxM = number.get(1) - number.get(0);
		for (int i = 1; i < n - 1; i++) {
			maxM = gcd(maxM, number.get(i + 1) - number.get(i));
		}
		output(maxM);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		number = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			number.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(number);
	}

	static int gcd(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int r = 1;
		while (r > 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	static void output(int m) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 2; i <= m; i++) {
			if (m % i == 0) {
				bw.write(Integer.toString(i) + ' ');
			}
		}
		bw.flush();
	}
}
