import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N14753 {
	static int n;
	static ArrayList<Integer> a = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		input();
		int temp1 = a.get(n - 1) * a.get(n - 2);
		if (a.get(n - 3) > 0) {
			temp1 *= a.get(n - 3);
		}
		int temp2 = a.get(0) * a.get(1);
		if (a.get(n - 1) > 0) {
			temp2 *= a.get(n - 1);
		}
		if (temp1 > temp2) {
			System.out.println(temp1);
		} else {
			System.out.println(temp2);
		}
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(a);
	}
}
