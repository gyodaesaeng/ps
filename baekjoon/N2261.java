import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N2261 {
	static int n;
	static Dot[] d;

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(solve());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		d = new Dot[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			d[i] = new Dot(x, y);
		}
	}

	static int solve() {
		Arrays.sort(d, new Comparator<Dot>() {
			public int compare(Dot d1, Dot d2) {
				return d1.x - d2.x;
			}
		});
		int dist = d[0].dist(d[1]);
		TreeSet<Dot> set = new TreeSet<Dot>();
		set.add(d[0]);
		set.add(d[1]);
		Dot low = new Dot(-10000, 0);
		Dot up = new Dot(10000, 0);
		for (int i = 2; i < n; i++) {
			int temp = (int) Math.ceil(Math.sqrt(dist));
			low.y = d[i].y - temp;
			up.y = d[i].y + temp;
			SortedSet<Dot> sub = set.subSet(low, up);
			Iterator<Dot> it = sub.iterator();
			while (it.hasNext()) {
				Dot next = it.next();
				if (sq(next.x - d[i].x) < dist) {
					dist = Math.min(dist, d[i].dist(next));
				} else {
					it.remove();
				}
			}
			set.add(d[i]);
		}
		return dist;
	}

	static int sq(int a) {
		return a * a;
	}

	static class Dot implements Comparable<Dot> {
		int x, y;

		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int dist(Dot dot) {
			return sq(x - dot.x) + sq(y - dot.y);
		}

		@Override
		public int compareTo(Dot o) {
			return y == o.y ? x - o.x : y - o.y;
		}
	}
}
