import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1547 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ball = 1;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			if (temp == ball) {
				ball = Integer.parseInt(st.nextToken());
			} else if (Integer.parseInt(st.nextToken()) == ball) {
				ball = temp;
			}
		}
		System.out.println(ball);
	}
}
