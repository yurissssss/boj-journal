import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        
        int idx = 0;
        int time = 0;
        int sum = 0;
        
        // 처음에 '0'으로 큐 채우기
        // -> bridge_length초까지는 트럭이 아닌 '0'이 빠져나감
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        while (idx < truck_weights.length) {
            time++;
            
            sum -= bridge.poll();
            
            if (sum + truck_weights[idx] <= weight) {
                sum += truck_weights[idx];
                bridge.offer(truck_weights[idx++]);
            } else {
                bridge.offer(0);
            }
        }
        
        return time + bridge_length;
    }
}