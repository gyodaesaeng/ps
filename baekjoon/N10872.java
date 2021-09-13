import java.util.Scanner;

public class N10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int a = 1;
		for(int i=1;i<=n;i++) {
			a*=i;
		}
		System.out.println(a);
	}
}
