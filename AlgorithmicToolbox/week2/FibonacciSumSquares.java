package week2;
import java.util.*;

public class FibonacciSumSquares {
	private static List<Long> al= new ArrayList<Long>();  
	private static long getSequenceLength(long m) {
        long previous = 0;
        al.add(previous);
        long current  = 1;
        al.add(current);
        long i = 0;
        do {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
            al.add(current);
            i++;
        } while (previous != 0 || current != 1);
        return i;
    }
	
	/**
	 * The above calculates the sequence length
	 * Then remember that the sum of fibonacci squares 𝐹0^2 + 𝐹1^2 + · · · + fn^2 = (f(n) + f(n-1)) * fn
	 * Last digit is the muodulo 10 but since we have calculated the sequence length we use pisano numbers
	 * @param n
	 * @return
	 */
    private static long getFibonacciSumSquares(long n) {
    	if (n <= 0) {
    		return 0;
    	}
    	long sequenceLength = getSequenceLength(10);
    	int mod = (int)((n) % sequenceLength); // Calculating index of the fn's last digit
    	int mod2 = (int)((n-1) % sequenceLength); // Calculating index of the fn-1's last digit
    	long current = al.get(mod);
    	long previous = al.get(mod2);
        return ((current + previous) * current) % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquares(n);
        System.out.println(s);
    }
}

