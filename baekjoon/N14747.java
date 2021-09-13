import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14747 {
	static int n,m,a=0,b=1001;
	static int[][] nodes;
	public static void main(String[] args) throws IOException{
		input();
		findCircle(0);
		if(a==0) {
			b = 0;
		}
		System.out.println(a + " " + b);
	}
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nodes = new int[m][3];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			nodes[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
	}
	static void findCircle(int q) {}
}