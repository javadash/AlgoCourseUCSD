package week5;
import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
	  //write your code here
	  int m = s.length(), n = t.length();
	  int[][] opt = new int[m+1][n+1];
	  for(int j = 1; j <= n; j++) opt[0][j] = j;
      for(int i = 1; i <= m; i++) opt[i][0] = i;
	  for (int i = 1; i <= m; i++) {
		  for (int j = 1; j <= n; j++) {
			  int insertion = opt[i][j - 1] + 1, 
	            	deletion = opt[i - 1][j] + 1,
	            	mismatch = opt[i - 1][j - 1] + (s.charAt(i - 1) == t.charAt(j - 1) ? 0 : 1);
	          opt[i][j] = Math.min(insertion, Math.min(deletion, mismatch));
		  }
	  }
    return opt[m][n];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
