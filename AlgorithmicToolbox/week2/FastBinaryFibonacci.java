package week2;

import week1.FastScanner;

public class FastBinaryFibonacci {
	public static int Huge_Fib(int n, int m) {
	    if (n == 0) {
	        return 0;
	    }
	    int v1 = 1, v2 = 1, v3 = 0;
	    for (char rec : Integer.toBinaryString(n).substring(1).toCharArray()) {
	        int calc = (v2 * v2) % m;
	        v1 = (v1 * v1 + calc) % m;
	        v2 = ((v1 + v3) * v2) % m;
	        v3 = (calc + v3 * v3) % m;
	        if (rec == '1') {
	            int temp = (v1 + v2) % m;
	            v1 = v2;
	            v2 = temp;
	        }
	    }
	    return v2;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
	    System.out.println(Huge_Fib(n, 10) -  1);
	}
}
