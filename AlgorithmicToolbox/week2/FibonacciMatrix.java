package week2;

/**
 * Fibonacci large module calculation using matrix exponentiation
 * @author Johnson
 *
 */
		
public class FibonacciMatrix {
	public static long fibModulo(long n, long m) {
	    if (n <= 1) {
	        return n;
	    }
	    
	    long[][] matrix = {{1, 1}, {1, 0}};
	    matrix = matrixPow(matrix, n - 1, m);
	    
	    return matrix[0][0] % m;
	}

	private static long[][] matrixPow(long[][] matrix, long pow, long m) {
	    if (pow == 1) {
	        return matrix;
	    }
	    
	    if (pow % 2 == 0) {
	        long[][] half = matrixPow(matrix, pow / 2, m);
	        return matrixMultiply(half, half, m);
	    } else {
	        long[][] half = matrixPow(matrix, pow / 2, m);
	        long[][] result = matrixMultiply(half, half, m);
	        return matrixMultiply(result, matrix, m);
	    }
	}

	private static long[][] matrixMultiply(long[][] a, long[][] b, long m) {
	    int n = a.length;
	    long[][] c = new long[n][n];
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            for (int k = 0; k < n; k++) {
	                c[i][j] += a[i][k] * b[k][j];
	                c[i][j] %= m;
	            }
	        }
	    }
	    return c;
	}

}
