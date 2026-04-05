import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 현재 숫자를 기준으로 앞에 자기보다 작은 숫자가 얼마나 있는지 확인
        int[] dp = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            max = Math.max(max, dp[i]);
        }
        
        System.out.print(max);
        br.close();
    }
}