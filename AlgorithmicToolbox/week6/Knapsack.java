package week6;
import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
    	
    	int resultTable[][] = new int[w.length + 1][W + 1]; 
    	
    	for(int i = 1; i <=w.length ; i++) resultTable[i][0] = 0;  // when the sack's weight is 0
    	for(int j = 1; j <=W ; j++) resultTable[0][j] = 0;  // when bars weight is 0
    	
        for (int i = 1; i<= w.length; i++) {
        	for (int j = 1; j <= W; j++) {
        		resultTable[i][j] = resultTable[i-1][j];
        		if (w[i-1] <= j) {
        			int val = resultTable[i-1][j-w[i-1]] + w[i-1];
        			if(resultTable[i][j] < val) resultTable[i][j] = val;
        		}
        	}
        }
        return resultTable[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

