import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        System.out.print(bfs(N));
        br.close();
    }
    
    private static int bfs(int n) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        
        q.offer(new int[]{n, 0});
        visited[n] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == K) return cur[1];
            
            int[] dx = {cur[0] - 1, cur[0] + 1, cur[0] * 2};
            
            for (int next : dx) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cur[1] + 1});
                }
            }    
        }
        
        return -1;
    }
}