import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            
            switch(order) {
                case 1:
                    dq.push(Integer.parseInt(st.nextToken()));
                    break;
                    
                case 2:
                    dq.offer(Integer.parseInt(st.nextToken()));
                    break;
                    
                case 3:
                    sb.append(dq.isEmpty() ? -1 : dq.pop()).append("\n");
                    break;
                    
                case 4:
                    sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n");
                    break;
                    
                case 5:
                    sb.append(dq.size()).append("\n");
                    break;
                    
                case 6:
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                    
                case 7:
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
                    break;
                    
                case 8:
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
                    break;  
            }
        }
        
        System.out.print(sb);
        
        br.close();
    }
}