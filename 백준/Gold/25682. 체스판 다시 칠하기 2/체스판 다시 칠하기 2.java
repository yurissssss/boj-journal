import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][M + 1];
        
        for (int i = 1; i < N + 1; i++) {
            String s = br.readLine();
            
            for (int j = 1; j <= M; j++) {
                char exp = ((i + j) % 2 == 0) ? 'W' : 'B';
                int wrong = s.charAt(j - 1) == exp ? 0 : 1;
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] 
                    + wrong;
            }
        }
        
        int answer = N * M;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int count = dp[i][j] - dp[i - K][j] - dp[i][j - K] + dp[i - K][j - K];
                answer = Math.min(answer, Math.min(count, K * K - count));
            }
        }

        
        System.out.print(answer);
        br.close();
    }
}