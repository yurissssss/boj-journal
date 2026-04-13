import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            if (n == 0) break;
            long[] height = new long[n];
            
            for (int i = 0; i < n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            
            // 이전 막대보다 작은 막대 만나면 스택 정리
            Deque<Integer> stack = new ArrayDeque<>();
            long max = 0;
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                    long h = height[stack.pop()];
                    long w = 0;
                    
                    if (stack.isEmpty()) w = i;
                    else w = i - stack.peek() - 1;
                    
                    max = Math.max(max, h * w);
                }
                
                stack.push(i);
            }
            
            // 남은 막대 처리
            while (!stack.isEmpty()) {
                long h = height[stack.pop()];
                long w = 0;
                
                if (stack.isEmpty()) w = n;
                else w = n - stack.peek() - 1;
                
                max = Math.max(max, h * w);
            }
            
            sb.append(max).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}