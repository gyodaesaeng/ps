import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[3];
		for (int i = 0; i < 3; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int round = 0;
		while (a[1] != a[2]) {
			for (int i = 1; i < 3; i++) {
				a[i] = (a[i] / 2) + a[i] % 2;
			}
			round++;
		}
		System.out.println(round);
	}
}
