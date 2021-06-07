package week2;

public class FibonacciMemo {
	public static int calc_fibo(int n) {
		int[] arr  = new int[n]; 
		if (n <= 1) {
			arr[n]  = n;
		} else {
			arr[n] = calc_fibo(n - 2) + calc_fibo(n -1);
		}
		return arr[n];
	}
}
