import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10802 {
	static String a,b;
	static int[][] memo;
	public static void main(String[] args)throws IOException{
		input();
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = st.nextToken();
		b = st.nextToken();
	}
	
	static int solve() {
		memo = new int[b.length()][10];
		int ans = 0;
		return ans;
	}
}
