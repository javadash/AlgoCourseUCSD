package week3;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Largest Concatenate Problem
 * Compile the largest number by concatenating the given numbers.
 */

public class MaximumSalary {
	public static int largestConcatenateInvalid(int[] numbers) {
		String yourSalary = "";
		
		ArrayList<Integer> numList = Arrays.stream(numbers)
				.boxed()
				.collect(Collectors.toCollection(ArrayList::new));
		while(!numList.isEmpty()) {
			Integer maxNum = Integer.MIN_VALUE;
			for(Integer num : numList) {
				if (num >= maxNum) maxNum = num;
			}
			yourSalary = yourSalary + maxNum;
			numList.remove(Integer.valueOf(maxNum));
		}
		return Integer.parseInt(yourSalary);
	}
	
	public static int largestConcatenate(int[] numbers) {
		List<String> list = Arrays.stream(numbers).mapToObj(String::valueOf).sorted(new Comparator<String>() {
    		@Override
    		public int compare(String s1, String s2) {
    			String a = s1 + s2;
    			String b = s2 + s1;
    			return b.compareTo(a);
    		}
    	}).collect(Collectors.toList());
		System.out.println(list);
		return 0;
	}
	
	public static void main(String[] args) {
		int[] input = new int[]{21, 2};
		System.out.println(largestConcatenateInvalid(input));
		
		System.out.println();
		input = new int[]{9, 4, 6, 1, 9};
		System.out.println(largestConcatenateInvalid(input));
		largestConcatenate(input);
		
		if( String.valueOf(253).compareTo(String.valueOf(2)) < 0) System.out.println("True");
		
	}
}
