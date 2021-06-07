package week1;

public class MaxPairwiseProductTwoN {
	
	/**
	 * 2N Comparisons for Max Pairwise Product
	 * @param numbers
	 * @return
	 */
	
	
	static long getMaxPairwiseProduct(int[] numbers) {
		int n = numbers.length;

		int firstIndex = 0;
		int secondIndex = 0;
		
		for (int i = 1; i < n; i++) {
			if(numbers[i] > numbers[firstIndex]) {
				firstIndex = i;
			}
		}
		
		if (firstIndex == 0) {
			secondIndex = 1;
		} else {
			secondIndex = 0;
		}
		
		for (int j = 0; j < n; j++) {
			if(j != firstIndex && numbers[j] > numbers[secondIndex]) {
				secondIndex = j;
			}
		}
		
		return (long)numbers[firstIndex] * (long)numbers[secondIndex];
		
	}
	
	public static void main (String [] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		System.out.println(getMaxPairwiseProduct(numbers));
	}

}
