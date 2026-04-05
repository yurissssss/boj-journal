import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            for (int j = K; j >= w; j--) {
                // 현재 물건 안 넣기 vs 현재 물건만큼 무게가 빈 상황에서 현재 물건 추가
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        
        System.out.print(dp[K]);
        br.close();
    }
}