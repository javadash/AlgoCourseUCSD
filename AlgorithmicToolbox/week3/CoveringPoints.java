package week3;

import java.util.*;
import java.util.stream.Collectors;

public class CoveringPoints {
	public static void main(String[] args) {
	     
	    // Initializing vector of pairs
	    ArrayList<int[]>seg = new ArrayList<>();
	     
	    // Push segments
	    seg.add(new int[]{0, 3});
	    seg.add(new int[]{1, 3});
	    seg.add(new int[]{3, 8});
	     
	    // Given points
	    int[] point = {-1, 3, 7};
	     
	    int s = seg.size();
	    int p = point.length;
	     
	    getCoveredPoints(seg, point);
	}

	private static void getCoveredPoints(ArrayList<int[]> seg, int[] points) {
		int numOfPoints = points.length;
		int numOfSegments = seg.size();
		
		List<Integer> mPoints = Arrays.stream(points).boxed().collect(Collectors.toList());
		
		while(!mPoints.isEmpty()) {
			int minPoint = mPoints.stream().min(Integer::compare).get();
		}

	}
	

}
