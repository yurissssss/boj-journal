import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1; 
        dp[2] = dp[1] + 1;
        dp[3] = dp[1] + dp[2] + 1;
        
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            sb.append(dp[target]).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}