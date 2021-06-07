package week2;
import java.util.*;

public class FibonacciPartialSum {
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
	
	private static long getFibonacciSum(long n) {
    	long sequenceLength = getSequenceLength(10);
    	int mod = (int)((n+2) % sequenceLength); // Calculating index of the fibonaccis sums last digit
    	long fiboNumber = al.get(mod);
    	if (fiboNumber == 0) return 9;
    	else return fiboNumber - 1;
    }
	
    private static long getFibonacciPartialSum(long from, long to) {
    	long toSum = getFibonacciSum(to);
    	long fromSum = getFibonacciSum(from - 1);
    	if (toSum < fromSum) return 10 + toSum - fromSum;
    	return toSum - fromSum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

