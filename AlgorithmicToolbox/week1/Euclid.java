package week1;
import java.util.Scanner;

public class Euclid {
	public static int gcd(int p, int q) {
		if(q == 0) {
			return p;
		}
		return gcd( q, p%q);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int p = s.nextInt();
		int q = s.nextInt();
		int divisor = gcd(p, q);
		System.out.println(divisor);
	}
}
