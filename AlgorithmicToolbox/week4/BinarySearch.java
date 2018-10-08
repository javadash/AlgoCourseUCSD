package week4;
import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
    	int left = 0;
    	int right = a.length;
    	return binarySearchHelper(a, left, right-1, x);
    }
    
    static int binarySearchHelper(int[] a, int l, int r, int x){
    	int middle = (l + r) / 2;
    	if (x > a[r] || x < a[l]) return -1;
    	if (r - l == 0 && a[l] != x) return -1;
        
        if (x  < a[middle]) return binarySearchHelper(a, l, middle - 1, x);
        else if (x > a[middle]) return binarySearchHelper(a, middle + 1, r, x);
        else return middle;
    }
    
    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
