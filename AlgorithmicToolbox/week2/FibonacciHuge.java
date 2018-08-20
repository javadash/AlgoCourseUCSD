package week2;
import java.util.*;

public class FibonacciHuge {
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
	 * This solution works by using pisano numbers and find the length of the seqeunce for the module
	 * then the sequence is used to find the module for the fibonacci number
	 * @param n this is the fibonacci number being sought
	 * @param m this is the module used
	 * @return
	 */
    private static long getFibonacciHuge(long n, long m) {
    	long sequenceLength = getSequenceLength(m);
    	int mod = (int)(n % sequenceLength);
    	long fiboNumber = al.get(mod);
    	return fiboNumber;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}