import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        System.out.print(bfs(0, 0, 0));
        br.close();
    }
    
    private static int bfs(int x, int y, int count) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        // 구해야 하는 것: 거리 ❎, 지나간 칸 수 🅾️
        q.offer(new int[]{x, y, 1});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == n - 1 && cur[1] == m - 1) return cur[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int dist = cur[2];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        
                        q.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        return -1;
    }
}