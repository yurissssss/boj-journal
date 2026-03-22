import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // n = 1이면 ArrayIndexOutOfBounds 오류 발생
        if (n >= 2) dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            // dp[i - 1]에 세로타일 1개 추가, dp[i - 2]에 가로타일 2개 추가
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        
        System.out.print(dp[n]);
        br.close();
    }
}