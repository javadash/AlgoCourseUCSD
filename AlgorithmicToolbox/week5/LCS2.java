package week5;
import java.util.Scanner;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
    	
    	int dp[][] = new int[a.length + 1][b.length + 1];
    	
    	for (int i = 1; i <= a.length; i++) {
    		for (int j = 1; j <= b.length; j++) {
    			if (a[i - 1] == b[j - 1]) {
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + 1;
    			} else {
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    			}
    		}
    	}
        //Write your code here
        return dp[a.length][b.length];
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("This is the start of the 1st sequence");
//        int n = scanner.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
//
//        System.out.println("This is the start of the 2nd sequence");
//        int m = scanner.nextInt();
//        int[] b = new int[m];
//        for (int i = 0; i < m; i++) {
//            b[i] = scanner.nextInt();
//        }
        
        int []a = new int[] {7,2,9,3,1,5,9, 4};
        int []b = new int[] {2,8,1,3,9,7};

        System.out.println(lcs2(a, b));
    }
}