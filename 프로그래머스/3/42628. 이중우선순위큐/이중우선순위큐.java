import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        for (String operation : operations) {
            char order = operation.charAt(0);
            char sign = operation.charAt(2);
            
            if (order == 'I') {
                int i = Integer.parseInt(operation.substring(2));
                maxQ.offer(i);
                minQ.offer(i);
                // 예외상황 고려: !minQ.isEmpty()
            } else if (order == 'D' && sign == '-' && !minQ.isEmpty()) {
                int i = minQ.poll();
                maxQ.remove(i);
            } else if (order == 'D' && sign != '-' && !minQ.isEmpty()) {
                int i = maxQ.poll();
                minQ.remove(i);
            } else continue;
        }
        
        
        if (!minQ.isEmpty()) {
            return new int[]{maxQ.poll(), minQ.poll()};
        } else return new int[]{0, 0};
    }
}