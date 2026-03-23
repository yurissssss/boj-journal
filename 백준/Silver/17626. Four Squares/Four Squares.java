import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // 처음에는 1^2을 i번 더하는 경우로 설정
            dp[i] = i;
            
            for (int j = 1; j * j <= i; j++) {
                // dp[i - j * j] + 1
                // -> j^2가 마지막에 들어간다고 생각하고 j^2를 뺀 수의 경우의 수
                // ex) dp[13] = Math.min(dp[13], dp[9] + 1);
                //     -> dp[9] + 1: 13 = 9 + 2^2
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        System.out.print(dp[n]);
        br.close();
    }
}