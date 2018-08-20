package week2;
import java.util.*;

public class FibonacciSumLastDigit {
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
	 * Calculate the sequence length
	 * Then remember that the sum if fibonacci fn = f(n+2) - 1
	 * Last digit is the muodulo 10 but since we have calculated the sequence length we use pisano numbers
	 * @param n
	 * @return
	 */
    private static long getFibonacciSum(long n) {
    	long sequenceLength = getSequenceLength(10);
    	int mod = (int)((n+2) % sequenceLength); // Calculating index of the fibonaccis sums last digit
    	long fiboNumber = al.get(mod);
    	if (fiboNumber == 0) return 9;
    	else return fiboNumber - 1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}

