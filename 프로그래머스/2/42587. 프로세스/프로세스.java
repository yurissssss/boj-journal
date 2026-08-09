import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});
        }
        
        int count = 0;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            boolean hasHigher = false;
            
            for (int[] i : q) {
                if (i[1] > current[1]) {
                    hasHigher = true;
                    break;
                } 
            }
            
            if (hasHigher) q.offer(current);
            else {
                count++;
                
                if (current[0] == location) return count;
            }
        }
        return count;
    }
}