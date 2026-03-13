import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] mine = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            mine[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(mine);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            
            if (binarySearch(mine, target)) sb.append(1).append(' ');
            else sb.append(0).append(' ');
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right  = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}