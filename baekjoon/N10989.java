import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class N10989 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 1);
		int n = Integer.parseInt(br.readLine());
		int[] nList = new int[10000];
		for (int i = 0; i < n; i++) {
			nList[Integer.parseInt(br.readLine()) - 1]++;
		}
		br.close();
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < nList[i]; j++) {
				bw.write(Integer.toString(i + 1));
				bw.newLine();
				bw.flush();
			}
		}
	}
}
