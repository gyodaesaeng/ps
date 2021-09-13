import java.util.*;
import java.io.*;

public class N4344 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		ArrayList<Integer> score = new ArrayList<Integer>();
		int m;
		double avr;
		double ratio;
		for (int i = 0; i < n; i++) {
			m = sc.nextInt();
			avr = 0;
			score.clear();
			for (int j = 0; j < m; j++) {
				score.add(sc.nextInt());
				avr += score.get(j);
			}
			avr /= m;
			ratio = 0;
			for (int j = 0; j < m; j++) {
				if (score.get(j) > avr) {
					ratio++;
				}
			}
			ratio = (ratio * 100) / m;
			bw.write(String.format("%.3f", ratio) + "% \n");
		}
		sc.close();
		bw.flush();
	}
}
