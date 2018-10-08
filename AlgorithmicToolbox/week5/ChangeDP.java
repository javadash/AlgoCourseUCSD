package week5;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int total){
    	int coins[] = {1, 3, 4};
        int T[] = new int[total + 1];
        T[0] = 0;
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

