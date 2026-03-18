import java.io.*;
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
                    int x = Integer.parseInt(st.nextToken());
                    queue.offer(x);
                    break;
                    
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                    break;
                    
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                    
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                    
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
                    break;
                    
                default:
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
            }
        }
        
        System.out.print(sb);
        
        br.close();
    }
}