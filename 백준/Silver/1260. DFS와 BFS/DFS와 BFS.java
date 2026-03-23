import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  // 정점의 개수
        int M = Integer.parseInt(st.nextToken());  // 간선의 개수
        int V = Integer.parseInt(st.nextToken());  // 시작할 번호
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');
        
        visited = new boolean[N + 1];
        bfs(V);
        
        System.out.print(sb);
        br.close();
    }
    
    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(' ');
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    private static void bfs(int node) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        dq.offer(node);
        visited[node] = true;
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            sb.append(cur).append(' ');
            
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dq.offer(next);
                }
            }
        }
    }
}