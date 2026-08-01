import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') dq.offer(cur);
            else if (!dq.isEmpty()) dq.poll();
            else {
                return false;
            }
        }
        
        if(dq.isEmpty()) return true;
        else return false;
    }
}