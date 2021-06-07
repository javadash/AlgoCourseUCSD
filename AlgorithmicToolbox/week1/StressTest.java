package week1;

public class StressTest {
	public static void StressTester(int length, int maxValue) {
		while(true) {
			int n = (int) (2 + (length-2)*Math.random());
			int[] numArray =  new int[n];
			for(int i = 0; i < n; i++) {
				numArray[i] = (int) (maxValue*Math.random());
			}
			printArray(numArray);
			long result1 = MaxPairwiseProductFaster.getMaxPairwiseProduct(numArray);
			long result2 = MaxPairwiseProductFast.getMaxPairwiseProduct(numArray);
			if (result1 == result2){
				System.out.println("OK");
			} else {
				System.out.println("Wrong result: " + result1 + " " + result2);
				break;
			}
		}
	}
	private static void printArray(int[] anArray) {
	      for (int i = 0; i < anArray.length; i++) {
	         if (i > 0) {
	            System.out.print(", ");
	         }
	         System.out.print(anArray[i]);
	      }
	      System.out.println();
	  }
	public static void main(String args[]) {
		StressTester(100, 100000);
	}

}
