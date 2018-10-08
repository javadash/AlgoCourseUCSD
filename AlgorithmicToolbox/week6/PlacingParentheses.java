package week6;
import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
    	int n = exp.length() / 2 + 1;
    	if (n == 1) return Integer.parseInt(exp);
    	long min[][] = new long[n][n];
    	long max[][] = new long[n][n];
    	
    	for(int i = 0; i < n; i++) {
            //min[i][i] = Integer.parseInt(String.valueOf(exp.charAt(i * 2)));
            //max[i][i] = Integer.parseInt(String.valueOf(exp.charAt(i * 2)));
            min[i][i] = exp.charAt(i * 2) - '0';
            max[i][i] = exp.charAt(i * 2) - '0';
        }
    	for(int s = 1; s <= n - 1; s++) {
    		for(int i = 0; i <= n - 1 - s; i++) {
    			int j = i + s;
                long[] res = getMinAndMax(exp, i, j, min, max);
                min[i][j] = res[0];
                max[i][j] = res[1];
    		}
    	}
    	return max[0][n - 1];
    }
    
    
    private static long[] getMinAndMax(String exp, int i, int j, long min[][], long max[][]) {
    	long[] result = new long[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
    	for(int k = i; k <= j - 1; k++) {
    		char oper = exp.charAt(k * 2 + 1);
    		long a = eval(min[i][k], min[k + 1][j], oper),
    				b  = eval(min[i][k], max[k + 1][j], oper),
    				c  = eval(max[i][k], min[k + 1][j], oper),
    				d  = eval(max[i][k], max[k + 1][j], oper);
    		result[0] = Math.min(a, Math.min(b,
    				Math.min(c, Math.min(d, result[0]))));
    		result[1] = Math.max(a, Math.max(b,
    				Math.max(c, Math.max(d, result[1]))));
    	}
    	return result;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

