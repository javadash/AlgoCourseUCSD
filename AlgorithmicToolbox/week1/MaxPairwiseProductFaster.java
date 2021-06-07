package week1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Algorithm - https://stackoverflow.com/a/53349558/7697971
 * @author Johnson
 *
 */
public class MaxPairwiseProductFaster {
	static long getMaxPairwiseProduct(int[] numbers) {
		//int[] numsCopy = numbers.clone();
		//int n = numsCopy.length;
		List<Integer>numsList = Arrays.stream(numbers)
			      .boxed()
			      .collect(Collectors.toList());
		int n = numsList.size();
		LinkedList<Integer> largestValue = max(0, n - 1, numsList);
		int m = largestValue.size();
		LinkedList<Integer> secondLargestValue = max(0, m - 2, largestValue.subList(1, m));
		return (long)largestValue.getFirst() * (long)secondLargestValue.getFirst() ;
	}
	
	static LinkedList<Integer> max (int low, int high, List<Integer> A) {
		if (low >= high) {
			return new LinkedList<Integer>(){{
				addFirst(A.get(low));
			}};
		} else {
			int mid = low +  (high - low) / 2;
			LinkedList<Integer> leftHalf = max(low, mid, A);
			LinkedList<Integer> rightHalf = max(mid + 1, high, A);
			
			if(leftHalf.getFirst() > rightHalf.getFirst()) {
				leftHalf.add(rightHalf.getFirst());
				return leftHalf;
			} else {
				rightHalf.add(leftHalf.getFirst());
				return rightHalf;
			}
		}
		
	}
	
	public static void main(String[] args) {
/*		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}*/
		
		int[] numbers = new int[] {16,2,4,5,7,9,10,3,8};
		System.out.println(getMaxPairwiseProduct(numbers));
	}

	
/*	static SortedMap<Integer, List<Integer>> max (int low, int high, int[] A) {
		if (low >= high) {
			return new TreeMap<Integer, List<Integer>>() {{
				put(low, new LinkedList<Integer>());
			}};
		} else {
			int mid = low +  (high - low) / 2;
			SortedMap<Integer, List<Integer>> leftHalf = max(low, mid, A);
			SortedMap<Integer, List<Integer>> rightHalf = max(low, mid, A);
			
			if(leftHalf.firstKey() > rightHalf.firstKey()) {
				leftHalf.get(leftHalf.firstKey()).add(rightHalf.firstKey());
				return leftHalf;
			} else {
				rightHalf.get(rightHalf.firstKey()).add(leftHalf.firstKey());
				return rightHalf;
			}
		}
		
	}*/

}
