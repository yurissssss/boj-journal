import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        arr = new int[m];
        
        dfs(n, m, 0);
        
        System.out.print(sb);
        
        br.close();
    }
  
    private static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                
                dfs(n, m, depth + 1);
                
                visited[i] = false;
            }
        }
    }
}