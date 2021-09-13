import java.util.Scanner;

public class N11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		if(k>n/2) {
			k = n-k;
		}
		int a  = 1;
		for(int i=n;i>n-k;i--) {
			a *= i;
		}
		for(int i=1;i<=k;i++){
			a /= i;
		}
		System.out.println(a);
	}
}
