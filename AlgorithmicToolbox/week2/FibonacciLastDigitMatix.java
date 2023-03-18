package week2;


/*
 * To get the last digit of the sum of Fibonacci numbers, 
 * we can use the property that the sum of the first n Fibonacci numbers is equal to the (n+2)th Fibonacci number minus 1. 
 * Therefore, to find the last digit of the sum of the first n Fibonacci numbers, 
 * we can calculate the last digit of the (n+2)th Fibonacci number and subtract 1.

 * To calculate the last digit of the nth Fibonacci number efficiently, we can use matrix exponentiation. 
 * We can represent the nth Fibonacci number as the (0,1)th element of the matrix [(1,1), (1,0)] raised to the power n. 
 * The last digit of this element can be found by calculating the matrix power modulo 10.
 * 
 * Here is the Java code for finding the last digit of the sum of the first n Fibonacci numbers using matrix exponentiation:
 */

public class FibonacciLastDigitMatix {
	public static int getFibonacciSumLastDigit(long n) {
		if (n <= 1) {
			return (int) n;
		}
		long[][] matrix = { { 1, 1 }, { 1, 0 } };
		matrix = matrixPower(matrix, n + 2);
		int sumLastDigit = (int) ((matrix[0][1] - 1) % 10);
		if (sumLastDigit < 0) {
			sumLastDigit += 10;
		}
		return sumLastDigit;
	}

	public static long[][] matrixPower(long[][] matrix, long power) {
		if (power == 0) {
			return new long[][] { { 1, 0 }, { 0, 1 } };
		}
		if (power % 2 == 0) {
			long[][] halfPowerMatrix = matrixPower(matrix, power / 2);
			return matrixMultiply(halfPowerMatrix, halfPowerMatrix);
		} else {
			return matrixMultiply(matrix, matrixPower(matrix, power - 1));
		}
	}

	public static long[][] matrixMultiply(long[][] a, long[][] b) {
		long[][] result = new long[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < b.length; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
				result[i][j] %= 10;
			}
		}
		return result;
	}

}
