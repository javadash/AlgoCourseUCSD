package week3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFueling {
	public static int computeMinRefills(int distance, int tank, int[] stops) {
		int[] travelStops = new int[stops.length + 2];
		travelStops[0] = 0;
		travelStops[travelStops.length -1] = distance;
		System.arraycopy(stops, 0, travelStops, 1, stops.length);
		
		int curRefill = 0;
		int  numRefills = 0;
		while(curRefill <= stops.length) {
			int lastRefill = curRefill;
			while(curRefill <= stops.length && travelStops[curRefill + 1] - travelStops[lastRefill] <= tank){
				curRefill += 1;
			}
			if(curRefill == lastRefill) return -1;
			if(curRefill <= stops.length) {
				numRefills += 1;
			}
		}
		return numRefills;
	}
	
	
	
	
	// Recursive solution of the minimum number of refills problem
	
	public static int calcMinRefills(int location, int distance, int tank, int[] stops) {
		
		
		List<Integer> list = Arrays.stream(stops)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
		
		
		return calcMinRefillsHelper(location, distance, tank, list);
	}
	
	
	public static int calcMinRefillsHelper(int location, int distance, int tank, List<Integer>stops) {
		if(location + tank >= distance) {
			return 0;
		}
		if (stops.size() == 0 || stops.get(0) - location > tank) {
			return Integer.MAX_VALUE;
		}
		
		int lastStop = location;
		while (stops.size() > 0 && stops.get(0) - location <= tank) {
			lastStop = stops.get(0);
			stops.remove(0);
		}
		return 1 + calcMinRefillsHelper(lastStop, distance, tank, stops);
	}
	
	

	
	public static void main(String[] args) {
		String message = String.format("The minimum number for refill is %d.", computeMinRefills(950, 400, new int[] {200, 375, 550, 750}));
		System.out.println(message);
		
		String result = String.format("The minimum number for refill is %d.", computeMinRefills(200, 250, new int[] {100, 150}));
		System.out.println(result);
		
		System.out.println("Here is the recusive solution");
		message = String.format("The minimum number for refill is %d.", calcMinRefills(0, 950, 400, new int[] {200, 375, 550, 750}));
		System.out.println(message);
		
		result = String.format("The minimum number for refill is %d.", calcMinRefills(0, 200, 250, new int[] {100, 150}));
		System.out.println(result);
		
		
	}

}
