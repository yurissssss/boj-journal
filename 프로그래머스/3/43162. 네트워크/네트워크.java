import java.util.*;

class Solution {    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(n, computers, visited, i);
            }
        }
        
        return count;
    }
    
    private void dfs(int n, int[][] computers, boolean[] visited, int start) {
        visited[start] = true;
        
        for (int i = 0; i < n; i++) {
            if (computers[start][i] == 1 && !visited[i]) {
                dfs(n, computers, visited, i);
            }
        }
    }
}