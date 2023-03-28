package week3;
import java.util.*;

/*
 * Distinct Summands Problem 
 * 
 * Represent a positive integer as the sum of the maximum number of pairwise distinct positive integers.
 * 
 */

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int k = 1;
        while ((int)((k + 1)  * (k + 2) / 2 ) <= n) {
        	k += 1;
        }
        int delta =  n - ((k-1) * k / 2);
        for(int i = 1; i < k; i++) {
        	summands.add(i);
        }
        summands.add(delta);
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        
        System.out.println(summands);
        scanner.close();
    }
}

