import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // dp: 현재 칸까지에서 새로 칠해야 하는 칸 수
        // 현재 위치가 '0'인데 '-1'을 하면 #-1 -> #1부터 시작 
        int[][] dp = new int[N + 1][M + 1];
        
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            
            for (int j = 1; j <= M; j++) {
                char c = s.charAt(j - 1);
                // 'B'로 시작한다고 가정
                // -> 'W'로 시작하는 경우 = 전체 체스판 크기 - 'B'로 시작하는 경우
                // i + j: 윗칸도 고려
                char exp = ((i + j) % 2 == 0) ? 'B' : 'W';
                int wrong = c == exp ? 0 : 1;
                
                /*
                oㅣ  x = - + ㅣ - o
                -x   -> 앞 열 값 + 윗 행 값 - 공통된 부분
                */
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + wrong;
            }
        }
        
        int answer = K * K;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                // 전체 - 포함❎ 행 - 포함❎ 열 + 겹치는 부분
                int count = dp[i][j] - dp[i - K][j] - dp[i][j - K] + dp[i - K][j - K];
                
                answer = Math.min(answer, Math.min(count, K * K - count));
            }
        }
        
        System.out.print(answer);
        br.close();
    }
}