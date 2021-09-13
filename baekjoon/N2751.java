import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class N2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arrayList.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arrayList);
		for (int i = 0; i < n; i++) {
			bw.write(arrayList.get(i) + "\n");
		}
		bw.flush();
	}
}
