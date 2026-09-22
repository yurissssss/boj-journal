import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        return bfs(maps, visited);
    }
    
    private int bfs(int[][] maps, boolean[][] visited) {
        int n = maps.length;
        int m = maps[0].length;
        
        Deque<int[]> dq = new ArrayDeque<>();
        // {x, y, depth}
        dq.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!dq.isEmpty()) {
            int[] current = dq.poll();
            
            int x = current[0];
            int y = current[1];
            
            if (x == n - 1 && y == m - 1) {
                return current[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.offer(new int[]{nx, ny, current[2] + 1});
                }
            }
        }
        
        return -1;
    }
}