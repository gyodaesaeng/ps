import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1024 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		long m;
		int i = l;
		for (; i <= 100; i++) {
			if (((2 * n) - (i * i) + i) % (2 * i) == 0 && (m = ((2 * n) - (i * i) + i) / (2 * i)) > 0) {
				for (int j = 0; j < i; j++) {
					bw.write(Long.toString(m + j) + ' ');
				}
				break;
			}
		}
		if (i > 100) {
			bw.write("-1");
		}
		bw.flush();
	}
}
