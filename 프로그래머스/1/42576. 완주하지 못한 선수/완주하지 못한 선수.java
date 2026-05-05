import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
    Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) + 1);
        }
        
        String answer = "";
        for (int i = 0; i < participant.length; i++) {
            if (!map.containsKey(participant[i])) {
                answer = participant[i];
                break;
            } else {
                map.put(participant[i], map.get(participant[i]) - 1);
                if (map.get(participant[i]) == 0) {
                    map.remove(participant[i]);
                }
            }
        }
        
        return answer;
    }
}