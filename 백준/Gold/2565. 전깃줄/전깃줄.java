import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] line = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(line, (a, b) -> {
            return a[0] - b[0];
        });
        
        // LIS -> 증가하는 수열의 개수 구해서 전체에서 빼주기 --> 없애야 하는 전깃줄 개수
        int[] dp = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (line[j][1] < line[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            min = Math.min(min, n - dp[i]);
        }
        
        System.out.print(min);
        br.close();
    }
}