import java.util.*;

class Solution {
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "");
        
        return set.size();
    }
    
    private void dfs(String numbers, String current) {
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                
                String next = current + numbers.charAt(i);
                int n = Integer.parseInt(next);
                
                if (isPrime(n)) set.add(n);
                
                dfs(numbers, next);
                
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}