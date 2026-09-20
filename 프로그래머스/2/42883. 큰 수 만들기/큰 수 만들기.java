import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        dq.push(number.charAt(0));
        
        int count = 0;
        int idx = 1;
        
        while (idx < number.length()) {
            char c = number.charAt(idx++);
            
            while (!dq.isEmpty() && dq.peek() < c && count < k) {
                dq.pop();
                count++;
            }
            
            dq.push(c);
        }
        
        String answer = "";
        for (int i = 0; i < number.length() - k; i++) {
            answer += dq.pollLast();
        }
        
        return answer;
    }
}