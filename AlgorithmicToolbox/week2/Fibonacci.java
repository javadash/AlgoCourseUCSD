package week2;
import java.util.Scanner;

public class Fibonacci {
	private static long[] f = new long[50];
	private static long calc_fib(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (f[n] > 0) return f[n];
		f[n] = calc_fib(n - 1) + calc_fib(n - 2);
		return f[n];
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		System.out.println(calc_fib(n));
	}
}
