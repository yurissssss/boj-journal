import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            switch(order) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                    
                case "pop":
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.poll()).append("\n");
                    break;
                    
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                    
                case "empty":
                    if (queue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                    
                case "front":
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.peekFirst()).append("\n");
                    break;
                    
                case "back":
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.peekLast()).append("\n");
                    break;
            }
        }
        
        System.out.print(sb);
        
        br.close();
    }
}