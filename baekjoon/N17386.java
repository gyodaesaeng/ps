import java.util.Scanner;

public class N17386 {
	static Pair[] in;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		in = new Pair[4];
		for (int i = 0; i < 4; i++) {
			in[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		sc.close();
		boolean ans = ccw(0, 1, 2) * ccw(0, 1, 3) <= 0 && ccw(2, 3, 0) * ccw(2, 3, 1) <= 0;
		if (ccw(0, 1, 2) == 0 && ccw(0, 1, 3) == 0) {
			if (in[0].compareTo(in[1]) > 0) {
				Pair temp = in[0];
				in[0] = in[1];
				in[1] = temp;
			}
			if (in[2].compareTo(in[3]) > 0) {
				Pair temp = in[2];
				in[2] = in[3];
				in[3] = temp;
			}
			if (in[0].compareTo(in[3]) > 0 || in[1].compareTo(in[2]) < 0) {
				ans = false;
			}
		}
		System.out.print(ans ? 1 : 0);
	}

	static int ccw(int a, int b, int c) {
		long ans = (in[b].x - in[a].x) * (in[c].y - in[a].y) - (in[b].y - in[a].y) * (in[c].x - in[a].x);
		if (ans > 0) {
			return 1;
		}
		if (ans < 0) {
			return -1;
		}
		return 0;
	}

	static class Pair implements Comparable<Pair> {
		long x, y;

		Pair(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if (x - o.x == 0) {
				return (int) (y - o.y);
			}
			return (int) (x - o.x);
		}
	}
}
