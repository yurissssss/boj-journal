import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp = new int[31][31];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 중복 계산 막기 위해 조합 미리 계산
        for (int i = 0; i <= 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int west = Integer.parseInt(st.nextToken());
            int east = Integer.parseInt(st.nextToken());
            
            sb.append(dp[east][west]).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
}