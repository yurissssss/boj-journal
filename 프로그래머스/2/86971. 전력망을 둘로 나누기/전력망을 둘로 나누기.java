import java.util.*;

class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        int min = n;
        for (int[] wire : wires) {
            graph[wire[0]].remove(Integer.valueOf(wire[1]));
            graph[wire[1]].remove(Integer.valueOf(wire[0]));
            
            visited = new boolean[n + 1];
            
            int diff = Math.abs(n - 2 * dfs(graph, wire[0]));
            min = Math.min(min, diff);
            
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        return min;
    }
    
    private int dfs(List<Integer>[] graph, int start) {
        visited[start] = true;
        
        int count = 1;
        
        for (int next : graph[start]) {
            if (!visited[next]) {
                count += dfs(graph, next);
            }
        }
        
        return count;
    }
}