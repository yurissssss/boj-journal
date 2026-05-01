import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothMap = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            clothMap.put(clothes[i][1], clothMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        
        // map.values() : map의 value 모음
        for (int i : clothMap.values()) {
            answer *= i + 1;
        }
        
        return answer - 1;
    }
}