import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }
        
        int count = 0;
        while (pq.size() >= 2) {
            if (pq.peek() >= K) return count;
            
            int first = pq.poll();
            int second = pq.poll();
            
            pq.offer(first + second * 2);
            count++;
        }
        
        if (pq.peek() >= K) return count;
        else return -1;
    }
}