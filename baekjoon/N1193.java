import java.util.*;

public class N1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		int index = 1;
		int temp = 1;
		while (temp < x) {
			temp += ++index;
		}
		int mother;
		int son;
		if (index % 2 == 0) {
			mother = 1;
			son = index;
			for (int i = 0; i < temp - x; i++) {
				mother++;
				son--;
			}
		} else {
			mother = index;
			son = 1;
			for (int i = 0; i < temp - x; i++) {
				mother--;
				son++;
			}
		}
		System.out.println(son + "/" + mother);
	}
}
