import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String A = br.readLine();
        String B = br.readLine();
        
        int[][] dp = new int[A.length()][B.length()];
        for (int i = 0; i < A.length(); i++) {
            int a = A.charAt(i);
            
            for (int j = 0; j < B.length(); j++) {
                int b = B.charAt(j);
              
                if (a == b) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // #0이 아닌 두 글자가 같으면 -> 그 이전의 경우의 수 + 1
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    // 다르면 -> A / B 중 하나의 마지막 단어 버리기
                    int da = i > 0 ? dp[i - 1][j] : 0;
                    int db = j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] = Math.max(da, db);
                }
            }
        }
        
        System.out.print(dp[A.length() - 1][B.length() - 1]);
        br.close();
    }
}