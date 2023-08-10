package week5;

public class Fibonacci {
	static int fibonacci(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		
		int[] memo = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		
		for(int i = 2; i < n; i++) {
			memo[i] = memo[i -2] + memo[i -1];
		}
		return memo[n - 2] + memo[n - 1];
	}
	
	static int fibonacciDP (int n) {
		if (n == 0) return 0;
		int a = 0;
		int b = 1;
		for (int i = 2; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return a + b;
			
	}

}
