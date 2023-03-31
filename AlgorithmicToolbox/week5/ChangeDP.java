package week5;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int total){
    	int coins[] = {1, 3, 4};
        int T[] = new int[total + 1];
        // this first element being = 0 is the key to the way the second for loop works
        T[0] = 0;
        // Read - Change problem: Section "An Introduction to Dynamic Programming: The Change Problem" of [CP]
        // Find the minimum amount of money for each amount of money, m, from 0 to M
        // This algorithm with running time O(Md) calculates bestNumCoinsm for increasing values of m
        // This works because the best number of coins for some value m depends only on values less than
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
        }
        for(int coin : coins){
            for(int i=1; i <= total; i++){
                if(i >= coin){
                    if (T[i - coin] + 1 < T[i]) {
                        T[i] = 1 + T[i - coin];
                    }
                }
            }
        }
        return T[total];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

