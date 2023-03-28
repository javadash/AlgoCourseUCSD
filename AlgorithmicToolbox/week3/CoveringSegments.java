package week3;
import java.util.*;


/*
 * Covering Segments by Points Problem 
 * Find the minimum number of points needed to cover all given segments on a line.
 * You are responsible for collecting signatures from all tenants in a building.
 * For each tenant, you know a period of time when he or she is at home.
 * You would like to collect all signatures by visiting the building as few times as possible.
 */

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
    	
    	Arrays.sort(segments, new Comparator<Segment>() {
    		@Override
    		public int compare(Segment seg1, Segment seg2) {
    			return seg1.end - seg2.end;
    		}
    	});
    	
    	List<Integer> pointsList = new ArrayList<>();
    	int i = 0;
    	int n = segments.length;
    	while(i < n) {
    		int currPoint = segments[i].end;
    		pointsList.add(currPoint);
    		while(i < n && segments[i].start <= currPoint && currPoint <= segments[i].end) {
    			i++;
    		}
    	}
    	
    	

    	/**
    	 * Arrays stream seems to be important
    	 * See FractionalKnapsack code also
    	 */
    	 int[] points = Arrays.stream(pointsList.toArray(new Integer[0]))
    			 .mapToInt(Integer::intValue)
    			 .toArray();
    	 return points;

    }
    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
