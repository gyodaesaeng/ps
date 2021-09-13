import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Member[] members = new Member[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int old = Integer.parseInt(st.nextToken());
			Member m = new Member(old, i, st.nextToken());
			members[i] = m;
		}
		Arrays.sort(members);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			bw.write(members[i].old + " " + members[i].name);
			bw.newLine();
		}
		bw.flush();
	}
}

class Member implements Comparable<Member> {
	int old;
	int order;
	String name;

	Member(int old, int order, String name) {
		this.old = old;
		this.order = order;
		this.name = name;
	}

	@Override
	public int compareTo(Member m) {
		if (this.old > m.old) {
			return 1;
		} else if (this.old == m.old && this.order > m.order) {
			return 1;
		}
		return -1;
	}
}
