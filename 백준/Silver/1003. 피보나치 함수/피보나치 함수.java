import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[42][2];
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            for (int j = 2; j <= num; j++) {
                dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
            }
            
            sb.append(dp[num][0]).append(' ').append(dp[num][1]).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}