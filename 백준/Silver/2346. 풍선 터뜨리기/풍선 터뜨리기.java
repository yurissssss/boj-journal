import java.io.*;
import java.util.*;

public class Main {
    static class Balloon {
        int idx;
        int move;
        
        Balloon(int idx, int move) {
            this.idx = idx;
            this.move = move;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Deque<Balloon> queue = new ArrayDeque<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            queue.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
        }
        
        Balloon now = queue.poll();
        sb.append(now.idx).append(" ");
        
        while (!queue.isEmpty()) {
            int num = now.move;
            
            if (num > 0) {
                for (int i = 1; i < num; i++) {
                    queue.offer(queue.poll());
                }
                
                now = queue.poll();
            } else {
                for (int i = -1; i > num; i--) {
                    queue.push(queue.pollLast());
                }
                now = queue.pollLast();
            }
                
            sb.append(now.idx).append(" ");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}