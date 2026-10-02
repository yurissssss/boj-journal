import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        int time = 0;
        int sum = 0;
        int count = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            dq.offer(0);
        }
        
        while (count < truck_weights.length) {
            sum -= dq.poll();
            time++;
            
            if (sum + truck_weights[count] <= weight) {
                sum += truck_weights[count];
                dq.offer(truck_weights[count++]);
            } else dq.offer(0);
        }
        
        return time + bridge_length;
    }
}