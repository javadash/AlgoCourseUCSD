package week1;
import java.util.Arrays;



public class FindSecondLargest {
	
	/**
	 * https://stackoverflow.com/questions/9889679/find-second-largest-number-in-array-at-most-nlog%e2%82%82n%e2%88%922-comparisons/41306313#41306313
	 */
	static long getMaxPairwiseProduct(int[] numbers) {
		return 0;
	}

	private static int findSecondRecursive(int[] numbers) {
		int[] numCopy = numbers.clone();
		int n = numbers.length;
		int[] firstCompared = findMaxTournament(0, n - 1, numCopy); // n-1 comparisons;
		int[] secondCompared = findMaxTournament(2, firstCompared[0] - 1, firstCompared); // log2(n)-1  comparisons.
		// Total comparisons: n+log2(n)-2;
		return secondCompared[1];
	}

	private static int[] findMaxTournament(int low, int high, int[] A) {
		if (low == high) {
			int[] compared = new int[2];
			compared[0] = 2;
			compared[1] = A[low];
			return compared;
		}
		int mid = low  + (high - low) / 2;
		int[] compared1 = findMaxTournament(low, mid, A);
		int[] compared2 = findMaxTournament( mid + 1, high, A);
		if (compared1[1] > compared2[1]) {
			int k = compared1[0] + 1;
			int[] newcompared1 = new int[k];
			System.arraycopy(compared1, 0, newcompared1, 0, compared1[0]);
			newcompared1[0] = k;
			newcompared1[k - 1] = compared2[1];
			return newcompared1;
		}
		int k = compared2[0] + 1;
		int[] newcompared2 = new int[k];
		System.arraycopy(compared2, 0, newcompared2, 0, compared2[0]);
		newcompared2[0] = k;
		newcompared2[k - 1] = compared1[1];
		return newcompared2;
	}

	private static void printarray(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Demo.
		System.out.println("Origial array: ");
		int[] A = { 10, 4, 5, 8, 7, 2, 12, 3, 1, 6, 9, 11 };
		printarray(A);
		int secondMax = findSecondRecursive( A);
		Arrays.sort(A);
		System.out.println("Sorted array(for check use): ");
		printarray(A);
		System.out.println("Second largest number in A: " + secondMax);
	}
}