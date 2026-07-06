import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> dq = new ArrayDeque<>();
        dq.offer(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            char next = s.charAt(i);
            
            if (dq.isEmpty()) dq.push(next);
            else {
                if (dq.peek() == next) dq.poll();
                else dq.push(next);
            }
        }
        
        int answer = dq.isEmpty() ? 1 : 0;
        
        return answer;
    }
}