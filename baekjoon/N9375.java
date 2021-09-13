import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			ArrayList<String> groupName = new ArrayList<String>();
			ArrayList<Integer> groupNumber = new ArrayList<Integer>();
			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String temp = st.nextToken();
				boolean already = false;
				for (int k = 0; k < groupName.size(); k++) {
					if (temp.equals(groupName.get(k))) {
						already = true;
						groupNumber.set(k, groupNumber.get(k) + 1);
					}
				}
				if (already == false) {
					groupName.add(temp);
					groupNumber.add(1);
				}
			}
			int answer = 1;
			for (int j = 0; j < groupNumber.size(); j++) {
				answer *= groupNumber.get(j) + 1;
			}
			System.out.println(answer - 1);
		}
	}
}
