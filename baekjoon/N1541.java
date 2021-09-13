import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String plus = s;
		String minus = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '-') {
				plus = s.substring(0, i);
				minus = s.substring(i + 1);
				break;
			}
		}
		int sum = 0;
		StringTokenizer st = new StringTokenizer(plus, "+");
		while (st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(minus, "+-");
		while (st.hasMoreTokens()) {
			sum -= Integer.parseInt(st.nextToken());
		}
		System.out.println(sum);
	}
}