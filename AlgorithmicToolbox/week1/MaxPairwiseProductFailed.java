package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProductFailed {
	
	static long getMaxPairwiseProduct(int[] numbers) {
		int[] results = fasterMaxPairwiseAlgo(numbers);
		return (long)results[0] * (long)results[1];
	}
	
	/**
	 * Implementing an algorithm that find the 2 largest elements in n+[logn]-2
	 * 
	 * needs works
	 * 
	 */
	// TODO Algorithm for total comparisons: n+log2(n)-2;
	static int[] fasterMaxPairwiseAlgo(int[] numbers) { // 
		// Base case 
		int[] numCopy = numbers.clone();
		int n = numCopy.length;
		if (n == 2) {
			if(numCopy[0] > numCopy[1]) {
				return new int[] {0,1};
			} else {
				return new int[] {1,0};
			}
		}
		
		// Recursive case dividing the array into group of 2
		int half = n/2 ; 
		
		int [] arrayW = new int[half]; // keeps track of largest elements
		int [] arrayM = new int[half]; // keeps track of swaps
		
		for (int i = 0; i < half; i++) {
			// swap larger element into first position of pair
	        // set M[i] to 1 if pair was swapped, else 0
	        // move larger element into W
			if(numCopy[2*i] < numCopy[2*i + 1]) {
				int temp = numCopy[2*i]; 
				numCopy[2*i] = numCopy[2*i + 1];
				numCopy[2*i + 1] = temp;
				arrayM[i] = 1;
			} else {
				arrayM[i] = 0;
			}
			arrayW[i] = numCopy[2*i];
		}
		int[] result = fasterMaxPairwiseAlgo(arrayW);
		int largest = arrayM[result[0]];
		int nxtLargest= arrayM[result[1]];
		result[0] = 2*result[0] - 1;
		result[1] = 2*result[1] - 1;
		
		if(numCopy[result[0]+1] > numCopy[result[1]]) {
			result[1] = result[0] + 1;
			nxtLargest = 0 - largest;
		}
		return new int[] {result[0]+largest,result[1]+nxtLargest};
	}

	public static void main(String[] args) {
		/*FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		System.out.println(getMaxPairwiseProduct(numbers));
		System.out.println(fasterMaxPairwiseProduct(numbers)); */
		int[] numArray = new int[] {1,2,4,5,7,9,10,19};
		int[] numCopy = numArray.clone();
		//int[] result = fasterMaxPairwiseAlgo(numArray);
		//System.out.println(result[0] + " " + result[1]);
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
