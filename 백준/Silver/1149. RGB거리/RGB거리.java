import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] red = new int [N + 1];
        int[] green = new int [N + 1];
        int[] blue = new int [N + 1];
        
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N + 1][3];
        dp[1][0] = red[1];
        dp[1][1] = green[1];
        dp[1][2] = blue[1];
        
        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue[i];
        }
        
        
        System.out.print(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
        br.close();
    }
}