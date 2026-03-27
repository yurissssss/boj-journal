import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static Map<Integer, Integer> ladder;
    static Map<Integer, Integer> snake;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());  // 사다리
        M = Integer.parseInt(st.nextToken());  // 뱀
        
        ladder = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            ladder.put(a, b);
        }
        
        snake = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            snake.put(a, b);
        }        
        
        System.out.print(bfs(1, 0));
        br.close();
    }
    
    private static int bfs(int step, int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{step, idx});
        
        boolean[] visited = new boolean[101];
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 1; i <= 6; i++) {
                int next = cur[0] + i;
                
                if (next == 100) return cur[1] + 1;
                if (next > 100) continue;
                
                // 사다리
                if (ladder.containsKey(next)) next = ladder.get(next);
                // 뱀
                if (snake.containsKey(next)) next = snake.get(next);
                
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cur[1] + 1});
                }
            }
        }
        
        return -1;
    }
}