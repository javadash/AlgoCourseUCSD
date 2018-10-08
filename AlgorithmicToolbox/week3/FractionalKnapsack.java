package week3;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
    	
    
        double value = 0;
        if (capacity == 0) return value;
        int n = values.length;
        double[] vwRatio = new double[n];
        for (int i = 0; i < n; i++) {
        	vwRatio[i] = (double) values[i] /weights[i];
        }
        double [] x = Arrays.copyOf(vwRatio, vwRatio.length);
        Arrays.sort(x);
        for(int i = n-1; i >= 0; i--) {
        	if (capacity == 0) return value;
        	double maxRatio = x[i];
        	int j = Arrays.stream(vwRatio).boxed().collect(Collectors.toList()).indexOf(maxRatio);
        	int a = Math.min(weights[j], capacity);
        	value = value + (a * maxRatio);
        	capacity = capacity - a;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
    
    public static void printArray(double [] doubleArray) {
    	for(double d : doubleArray) {
    		System.out.print(d + " ");
    	}
    	System.out.println();
    }
} 
