import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] count = new long[M];
        count[0] = 1;  // 처음부터 M으로 나누어 떨어지는 경우 포함
        
        long answer = 0;
        long sum = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            int mod = (int) (sum % M);
            
            answer += count[mod]++;
        }
        
        
        System.out.print(answer);
        br.close();
    }
}