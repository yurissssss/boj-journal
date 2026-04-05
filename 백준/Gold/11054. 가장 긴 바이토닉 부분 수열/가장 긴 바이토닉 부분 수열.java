import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n];
        int[] rdp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 0;
            
            for (int j = 0; j < i; j++) {
               if (arr[j] < arr[i]) {
                   dp[i] = Math.max(dp[i], dp[j] + 1);
               }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            rdp[i] = 0;
            
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    rdp[i] = Math.max(rdp[i], rdp[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i] + rdp[i] + 1);
        }
        
        System.out.print(max);
        br.close();
    }
}