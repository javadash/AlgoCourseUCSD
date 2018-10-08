package week4;
import java.util.*;
import java.io.*;

public class MajorityElement {
	public static int getMajorityElement(int[] a, int left, int right) {
        int majority = -1, count = 0;
        for (int i = left; i < right; i++) {
            if (count == 0) {
                majority = a[i];
                count = 1;
            }
            else if (a[i] == majority) count++;
            else if (a[i] != majority) count--;
        }
        count = 0;
        // stills needs to check if really is majority
        for (int i = left; i < right; i++) {
            if (a[i] == majority) count++;
            if (count > right / 2) return majority;
        }
        return -1;
    }
	
	
    private static int getMajorityElement_Linearithmic(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        return majority(a, left, right - 1);
    }
    
    private static int majority(int[] a, int left, int right) {
    	if (left == right) return a[left];
        int mid = (right - left) / 2 + left;
        int left_major  = majority(a, left, mid);
        int right_major = majority(a, mid + 1, right);
        if (left_major == right_major) return left_major;
        
        // Get majority element with the largest count
        int left_count  = getCount(a, left_major);
        int right_count = getCount(a, right_major);
        // Check if majority is larger than n/2
        return left_count > a.length / 2 ? left_major :
            ( right_count > a.length / 2 ? right_major : -1 );
    }
    
    private static int getCount(int[] a, int largestNum) {
        int count = 0;
        for (int element : a) {
            if (element == largestNum) count++;
            if (count > a.length / 2) break;
        }
        return count;
    }
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

