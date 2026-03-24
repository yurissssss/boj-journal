import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 1; j < n + 1; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph[i].add(j);
                }
            }
        }
        
        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            dfs(i);
            
            for (int j = 1; j < n + 1; j++) {
                sb.append(visited[j] ? 1 : 0).append(' ');
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
    
    private static void dfs(int start) {
        for (int i : graph[start]) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}