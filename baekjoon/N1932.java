import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N1932 {
	static ArrayList<ArrayList<Integer>> numberList;
	static ArrayList<ArrayList<Integer>> maxList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		numberList = new ArrayList<ArrayList<Integer>>();
		maxList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			numberList.add(new ArrayList<Integer>());
			maxList.add(new ArrayList<Integer>());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				numberList.get(i).add(Integer.parseInt(st.nextToken()));
				maxList.get(i).add(null);
			}
		}
		int max = findMax(n - 1, 0);
		for (int i = 1; i < n; i++) {
			if (max < findMax(n - 1, i)) {
				max = findMax(n - 1, i);
			}
		}
		System.out.println(max);
	}

	static int findMax(int n, int k) {
		if (maxList.get(n).get(k) == null) {
			if (n == 0) {
				return numberList.get(0).get(0);
			}
			if (k == 0) {
				maxList.get(n).set(0, numberList.get(n).get(0) + findMax(n - 1, 0));
			} else {
				if (k == n) {
					maxList.get(n).set(k, numberList.get(n).get(k) + findMax(n - 1, k - 1));
				} else {
					maxList.get(n).set(k,
							numberList.get(n).get(k) + Math.max(findMax(n - 1, k - 1), findMax(n - 1, k)));
				}
			}
		}
		return maxList.get(n).get(k);
	}
}
