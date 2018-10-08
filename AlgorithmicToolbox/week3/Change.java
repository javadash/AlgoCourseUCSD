package week3;
import java.util.Scanner;

public class Change {
    public static int getChange(int m) {
        //write your code here
    	int numberOfCoins = 0;
    	int [] coinDemoninations = {10, 5, 1};
    	for(int coin : coinDemoninations) {
    		numberOfCoins += Math.floorDiv(m, coin);
    		m = m % coin;
    		if (m == 0) break;
    	}
        return numberOfCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

