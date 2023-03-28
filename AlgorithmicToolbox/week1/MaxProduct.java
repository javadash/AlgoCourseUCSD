package week1;
import java.util.Scanner;

public class MaxProduct {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int max = 0;
		int maxProd = 0;
		int [] numSeq = new int[a];
		for(int i = 0; i < a; i++) {
			numSeq[i] = s.nextInt();
			max = numSeq[i] > max ? numSeq[i] : max;
			if (i > 0 && (max != numSeq[i-1])) {
				maxProd = numSeq[i-1] * max > maxProd ? numSeq[i-1] * max : maxProd;	
			}
		}*/
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int max = 0;
		int nextMax = 0;
		int maxProd = 0;
		int [] numSeq = new int[a];
		for(int i = 0; i < a; i++) {
			numSeq[i] = s.nextInt();
			max = numSeq[i] > max ? numSeq[i] : max;
			if (i>0 && numSeq[i-1] != max && numSeq[i-1] > nextMax) {
				nextMax = numSeq[i-1];
			}
		}
		maxProd = max * nextMax;
		System.out.println(maxProd);
		s.close();
	}
}
