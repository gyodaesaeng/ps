import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Dot1[] dots = new Dot1[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			dots[i] = new Dot1(x, y);
		}
		Arrays.sort(dots);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			bw.write(dots[i].x + " " + dots[i].y);
			bw.newLine();
		}
		bw.flush();
	}
}

class Dot1 implements Comparable<Dot1> {
	int x;
	int y;

	Dot1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Dot1 d) {
		if (this.x > d.x) {
			return 1;
		} else if (this.x == d.x) {
			if (this.y > d.y) {
				return 1;
			}
		}
		return -1;
	}
}