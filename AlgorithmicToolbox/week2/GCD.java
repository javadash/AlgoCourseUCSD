package week2;
import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }
  private static int gcd_recursive(int a, int b) {
	  if (b == 0) return a;
	  return gcd_recursive(b, a%b);  
  }
  
  
  
//	private static int gcd_recursive(int a, int b) {
//		int larger = Math.max(a, b);
//		int smaller = Math.min(a, b);
//		if (smaller == 0)
//			return a;
//		return gcd_recursive(smaller, larger % smaller);
//	}

  public static void main(String args[]) {
//    Scanner scanner = new Scanner(System.in);
//    int a = scanner.nextInt();
//    int b = scanner.nextInt();
	  System.out.println(gcd_recursive(6, 10));
//	  System.out.println(6%10);
  }
}
