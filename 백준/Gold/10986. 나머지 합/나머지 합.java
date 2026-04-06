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
        long[] count = new long[M];  // 나머지: 0 ~ M-1
        /*
        나머지가 '0'이 아닌 경우
         -> 나머지가 'x'인 누적합 - 나머지가 'x'인 누적합
         --> 나머지가 '0'으로 상쇄됨
        나머지가 '0'인 경우
         -> 굳이 연산을 하지 않아도 처음부터 나머지가 '0'
         --> 그 경우를 위해 초기값을 '1'로 설정
        */
        count[0] = 1; 
        
        long answer = 0;
        long sum = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            // mod는 배열의 index -> 무조건 int!
            int mod  = (int) (sum % M);
            
            answer += count[mod]++;
        }
        
        System.out.print(answer);
        br.close();
    }
}