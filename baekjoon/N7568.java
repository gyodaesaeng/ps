import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] man = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			man[i][0] = Integer.parseInt(st.nextToken());
			man[i][1] = Integer.parseInt(st.nextToken());
			man[i][2] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (man[i][0] > man[j][0] && man[i][1] > man[j][1]) {
					man[j][2]++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(man[i][2] + " ");
		}
	}
}