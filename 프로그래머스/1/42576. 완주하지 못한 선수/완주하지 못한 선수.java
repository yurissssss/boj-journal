import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        Deque<String> dq = new ArrayDeque<>();
        for (String s : participant) {
            dq.offer(s);
        }
        
        while (!dq.isEmpty()) {
            String cur = dq.poll();
            
            if (map.containsKey(cur)) {
                if (map.get(cur) == 1) map.remove(cur);
                else map.put(cur, map.get(cur) - 1);
            } else return cur;
        }
        
        return "";
    }
}