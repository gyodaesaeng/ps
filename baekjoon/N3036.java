import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N3036 {
	static int n;
	static int[] r;

	public static void main(String[] args) throws IOException {
		input();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		r = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			r[i] = Integer.parseInt(st.nextToken());
		}
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

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i < n; i++) {
			int temp = gcd(r[0], r[i]);
			bw.write(Integer.toString(r[0] / temp) + '/' + Integer.toString(r[i] / temp));
			bw.newLine();
		}
		bw.flush();
	}
}
