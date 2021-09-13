import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N4195 {
	static int[] union, number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int f = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
			union = new int[f * 2];
			number = new int[f * 2];
			int index = 0;
			for (int j = 0; j < f; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int[] id = new int[2];
				for (int k = 0; k < 2; k++) {
					String s = st.nextToken();
					if (hashMap.containsKey(s)) {
						id[k] = hashMap.get(s);
					} else {
						hashMap.put(s, index);
						union[index] = index;
						number[index] = 1;
						id[k] = index++;
					}
				}
				bw.write(union(id[0], id[1]) + "\n");
			}
			bw.flush();
		}
	}

	static int find(int a) {
		if (a == union[a]) {
			return a;
		}
		return union[a] = find(union[a]);
	}

	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return number[a];
		}
		union[b] = a;
		return number[a] += number[b];
	}
}
