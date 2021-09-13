import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1005 {
	static BufferedReader br;
	static int n, k, w;
	static N1005.Graph graph;
	static int[] time;
	static int[] maxTime;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			input();
			maxTime = new int[n + 1];
			for (int j = 1; j <= n; j++) {
				maxTime[j] = -1;
			}
			System.out.println(getTime(w));
		}
	}

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		time = new int[n + 1];
		graph = new N1005().new Graph(n);
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			graph.addNode(start, to);
		}
		w = Integer.parseInt(br.readLine());
	}

	static int getTime(int node) {
		if (maxTime[node] > -1) {
			return maxTime[node];
		}
		int max = 0;
		ArrayList<Integer> nextNode = graph.getNode(node);
		for (int i = 0; i < nextNode.size(); i++) {
			if (max < getTime(nextNode.get(i))) {
				max = getTime(nextNode.get(i));
			}
		}
		maxTime[node] = max + time[node];
		return maxTime[node];
	}

	class Graph {
		int nVertex;
		ArrayList<ArrayList<Integer>> nodeList = new ArrayList<ArrayList<Integer>>();

		public Graph(int n) {
			this.nVertex = n;
			for (int i = 0; i <= n; i++) {
				nodeList.add(new ArrayList<Integer>());
			}
		}

		public void addNode(int start, int to) {
			nodeList.get(start).add(to);
		}

		public ArrayList<Integer> getNode(int a) {
			return nodeList.get(a);
		}

		public void endAddNode() {
			for (int i = 0; i <= nVertex; i++) {
				Collections.sort(nodeList.get(i));
			}
		}
	}
}