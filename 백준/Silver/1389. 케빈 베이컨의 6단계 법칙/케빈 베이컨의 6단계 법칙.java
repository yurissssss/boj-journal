import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int min = Integer.MAX_VALUE;
        int answer = 1;
        for (int i = 1; i <= n; i++) {
            int sum = bfs(i, n);
            
            if (sum < min) {
                min = sum;
                answer = i;
            }
        }
        
        System.out.print(answer);
        br.close();
    }
    
    private static int bfs(int start, int n) {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        
        dq.offer(start);
        visited[start] = true;
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    dq.offer(next);
                }
            }
        }
        
        int sum = 0; 
        for (int i = 1; i <= n; i++) {
            sum += dist[i];
        }
        
        return sum;
    }
}