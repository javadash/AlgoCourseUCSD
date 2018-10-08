package week6;
/**
 * Solution Owner - http://www.techiedelight.com/3-partition-problem/
 */
import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        //write your code here
    	int max = Arrays.stream(A).max().getAsInt();
    	int sum = Arrays.stream(A).sum();
    	int subSum = sum / 3;
    	if(A.length < 3 || sum % 3 > 0 || max > subSum ) return 0;
    	
    	
/*    	// Use 3D table, and consider a "slice" to be the grid when z is fixed to a certain value.
        // resultTable[x][y][z] = true if person 1 can have value x and person 2 can have value y out of the first z items.
    		
		int resultTable[][][] = new int[A.length + 1][subSum + 1][subSum + 1]; 
		for(int i = 1; i <=A.length ; i++) resultTable[i][0] = 1;  //when the partition sum is 0
    	for(int j = 1; j <=subSum ; j++) resultTable[0][j] = 0;  // when subset is empty
		
		for(int k = 1; k <= subSum; k++) {
			for(int l = 1; l <= A.length; l++) {
				if (k - A[l] >= 0) resultTable[l][k] = resultTable[l-1][k]
			}
		}
    	*/
    	Map<String, Boolean> resultMap= new HashMap<>();
    	boolean result = subSet(A, A.length - 1, subSum, subSum, subSum, resultMap);
    	if (result == true) return 1;
    	
    	return 0;
    }
    
    public static boolean subSet(int[] A, int n, int p1, int p2, int p3, Map<String, Boolean> resultMap) {
    	if(p1 == 0 && p2 == 0 && p3 ==0) return true;
    	if(n < 0) return false;
    	
    	String key = p1 + "|" + p2 + "|" + p3 + "|" + n;
    	
    	if(!resultMap.containsKey(key))
    	{
    		boolean P1 = false;
    		if(p1 - A[n] >= 0) P1 = subSet(A, n-1, p1 - A[n], p2, p3, resultMap);
    		
    		boolean P2 = false;
    		if(!P1 && (p2 - A[n] >= 0)) P2 = subSet(A, n-1, p1, p2 - A[n], p3, resultMap);
    		
    		boolean P3 = false;
    		if((!P1 && !P2) && (p3 - A[n] >= 0)) P3 = subSet(A, n-1, p1, p2 , p3- A[n], resultMap);
    		
    		resultMap.put(key, P1 || P2 || P3);
    	}
 
    	return resultMap.get(key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

