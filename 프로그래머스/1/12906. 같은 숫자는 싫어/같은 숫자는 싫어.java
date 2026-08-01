import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(arr[0]);
        
        for (int i : arr) {
            if (dq.peekLast() == i) continue;
            else dq.offer(i);
        }
        
        int[] answer = new int[dq.size()];
        
        int idx = 0;
        for (int i : dq) {
            answer[idx++] = i;
        }
        
        return answer;
    }
}