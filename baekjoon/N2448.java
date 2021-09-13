import java.util.*;
import java.io.*;

public class N2448 {
	public static char[][] star;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		star = new char[n][n * 2];
		int m = n / 3;
		int theNumber = 1;
		while (m != 1) {
			m = m / 2;
			theNumber++;
		}
		writeStar(theNumber, n - 1, 0);
		printStar(n);
	}

	private static void writeStar(int theNumber, int x, int y) {
		if (theNumber == 1) {
			star[y][x] = '*';
			star[y + 1][x - 1] = '*';
			star[y + 1][x + 1] = '*';
			for (int i = 0; i < 5; i++) {
				star[y + 2][x - 2 + i] = '*';
			}
		} else {
			writeStar(theNumber - 1, x, y);
			writeStar(theNumber - 1, (int) (x - (3 * Math.pow(2, theNumber - 2))),
					(int) (y + (3 * Math.pow(2, theNumber - 2))));
			writeStar(theNumber - 1, (int) (x + (3 * Math.pow(2, theNumber - 2))),
					(int) (y + (3 * Math.pow(2, theNumber - 2))));
		}
	}

	private static void printStar(int n) throws IOException {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n * 2; j++) {
				if (star[i][j] == '*') {
					bw.write("*");
				} else {
					bw.write(" ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
