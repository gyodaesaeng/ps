import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class N11779 {
	static int n, m, s, e;
	static int[] dist, path;
	static Stack<Integer> out;
	static ArrayList<Bus>[] in;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		in = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			in[i] = new ArrayList<Bus>();
		}
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int[] temp = new int[3];
			for (int j = 0; j < 3; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}
			in[temp[0]].add(new Bus(temp[0], temp[1], temp[2]));
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
	}

	static void solve() {
		dist = new int[n + 1];
		path = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Bus> pq = new PriorityQueue<Bus>();
		pq.add(new Bus(0, s, 0));
		dist[s] = 0;
		while (!pq.isEmpty()) {
			Bus peek = pq.poll();
			if (peek.d <= dist[peek.e]) {
				dist[peek.e] = peek.d;
				path[peek.e] = peek.s;
				for (Bus bus : in[peek.e]) {
					if (peek.d + bus.d < dist[bus.e]) {
						pq.add(new Bus(bus.s, bus.e, peek.d + bus.d));
					}
				}
			}
		}
		out = new Stack<Integer>();
		for (int i = e; i > 0; i = path[i]) {
			out.push(i);
		}
		out.push(dist[e]);
	}

	static void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(out.pop() + "\n");
		bw.write(out.size() + "\n");
		while (!out.isEmpty()) {
			bw.write(out.pop() + " ");
		}
		bw.flush();
	}

	static class Bus implements Comparable<Bus> {
		int s, e, d;

		Bus(int s, int e, int d) {
			this.s = s;
			this.e = e;
			this.d = d;
		}

		@Override
		public int compareTo(Bus o) {
			// TODO Auto-generated method stub
			return d - o.d;
		}
	}
}
