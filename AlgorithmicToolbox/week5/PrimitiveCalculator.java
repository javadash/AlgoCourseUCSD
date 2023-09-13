package week5;
import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int a = (i % 2) == 0 ? dp[i / 2] : Integer.MAX_VALUE;
            int b = (i % 3) == 0 ? dp[i / 3] : Integer.MAX_VALUE;
            int c = dp[i - 1];
            dp[i] = Math.min(a, Math.min(b, c)) + 1;
        }
        sequence.add(n);
        while (n > 1) {
        	if(dp[n-1] == dp[n] - 1) {
                sequence.add(n - 1);
                n -= 1;
            }
        	else if(n % 2 == 0 && dp[n] - 1 == dp[n / 2]) {
                sequence.add(n / 2);
                n /= 2;
            }
            else if(n % 3 == 0 && dp[n] - 1 == dp[n / 3]) {
                sequence.add(n / 3);
                n /= 3;
            }
            
        }
        Collections.reverse(sequence);
        return sequence;
    }
    
    public static int calculator(int n) {
    	int[] dp = new int[n + 1];
    	dp[1] = 0;
    	
    	for (int j = 2; j <= n; j++) {
    		dp[j] = 1 + dp[j - 1];
    		int a = (j % 2) == 0 ? 1 + dp[j / 2] : Integer.MAX_VALUE;
            int b = (j % 3) == 0 ? 1 + dp[j / 3] : Integer.MAX_VALUE;
            dp[j] = Math.min(a, Math.min(b, dp[j] ));
    	}
    	return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
        
        
//        int result = calculator(n);
//        System.out.println(result);
    }
}

