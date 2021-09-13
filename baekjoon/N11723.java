import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = Integer.parseInt(br.readLine());
		boolean[] s = new boolean[21];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("add")) {
				s[Integer.parseInt(st.nextToken())] = true;
			} else if (str.equals("remove")) {
				s[Integer.parseInt(st.nextToken())] = false;
			} else if (str.equals("check")) {
				if (s[Integer.parseInt(st.nextToken())]) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (str.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				s[x] = !s[x];
			} else if (str.equals("all")) {
				Arrays.fill(s, true);
			} else {
				Arrays.fill(s, false);
			}
		}
		bw.flush();
	}
}
