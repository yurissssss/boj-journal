import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] dp = new int[s.length() + 1][26];
        
        for (int i = 1; i <= s.length(); i++) {
            int alp = s.charAt(i - 1) - 'a';
            
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            
            dp[i][alp]++;
        }
        
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            // dp[i]는 #1부터 시작 -> #(r + 1) = r번째 문자
            sb.append(dp[r + 1][a] - dp[l][a]).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}