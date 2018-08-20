package week2;

public class StressTestFibonacci {
	public static void StressTester() {
		while(true) {
			int n = (int) (10_000_000 * Math.random());
			System.out.println(n + ": " + FibonacciLastDigit.getFibonacciLastDigitNaive(n));
		}
	}
	public static void main(String args[]) {
		StressTester();
	}
}
