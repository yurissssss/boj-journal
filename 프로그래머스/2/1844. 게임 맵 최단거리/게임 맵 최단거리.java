import java.util.*;

class Solution {
    int n = 0;
    int m = 0;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        return bfs(maps, 0, 0);
    }
    
    private int bfs(int[][] maps, int x, int y) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{x, y, 1});
        visited[x][y] = true;
        
        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            
            if (cur[0] == n - 1 && cur[1] == m - 1) return cur[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        
        return -1;
    }
}