package week1;
import java.util.Arrays;

public class SecondLargest {

	private static int findSecondRecursive(int n, int[] A) {
		int[] firstCompared = findMaxTournament(0, n - 1, A); // n-1 comparisons;
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
		int[] compared1 = findMaxTournament(low, (low + high) / 2, A);
		int[] compared2 = findMaxTournament((low + high) / 2 + 1, high, A);
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
		int secondMax = findSecondRecursive(A.length, A);
		Arrays.sort(A);
		System.out.println("Sorted array(for check use): ");
		printarray(A);
		System.out.println("Second largest number in A: " + secondMax);
	}
}