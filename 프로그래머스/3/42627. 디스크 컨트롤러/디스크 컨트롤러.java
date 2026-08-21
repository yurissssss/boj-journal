import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int time = 0;  // 소요시간
        int now = 0;  // 현재 시간
        int count = 0;  // 수행한 작업 수
        int end = -1;  // 끝난 시간 
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        while (count < jobs.length) {
            for (int[] job : jobs) {
                if (job[0] > end && job[0] <= now) {
                    pq.offer(new int[]{job[0], job[1]});
                }
            }
            
            if (!pq.isEmpty()) {
                int[] current = pq.poll();
                end = now;
                now += current[1];
                time += now - current[0];  // 소요시간 추가
                count++;
            } else now++;
        }
        
        return time / jobs.length;
    }
}