package week5;

import java.util.Scanner;

public class MinimumStepsToOne {
	public static int minimumStepsMemo(int n) {
		int memo[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			memo[i] = -1;
		}
		return getMinSteps(n, memo);
	}
	
	public static int minimumStepsDP(int n) {
		int dp[] = new int[n + 1];
		dp[1] = 0;
		
		for (int j = 2; j <= n; j++) {
			dp[j] = 1 + dp[j-1];
			if (j % 2 == 0) Math.min(dp[j], 1 + dp[j/2]);
			if (j % 3 == 0) Math.min(dp[j], 1 + dp[j/3]);
		}
		return dp[n];
	}

	public static int getMinSteps(int n, int[] dp) {
		if (n == 1) return 0;
		if (dp[n] != -1) return dp[n];
		int r = 1 + getMinSteps(n-1, dp);
		if (n % 2 == 0) r = Math.min(r, 1 + getMinSteps(n/2, dp));
		if (n % 3 == 0) r = Math.min(r, 1 + getMinSteps(n/3, dp));
		dp[n] = r;
		return r;
	}
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.printf("The minimum steps to get to one from %d is %d.", n, minimumStepsMemo(n));
	}
}
