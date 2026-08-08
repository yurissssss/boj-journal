import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        int sum = 0;
        int time = 0;
        int idx = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            dq.offer(0);
        }
        
        while (idx < truck_weights.length) {
            time++;
            
            sum -= dq.poll();
            
            if (sum + truck_weights[idx] <= weight) {
                sum += truck_weights[idx];
                dq.offer(truck_weights[idx++]);
            } else {
                dq.offer(0);
            }
        }
        
        return time + bridge_length;
    }
}