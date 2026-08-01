import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] rests = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            rests[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int count = 0;
        int prev = rests[0];
        for (int i : rests) {
            if (i <= prev) count++;
            else {
                answer.add(count);
                count = 1;
                prev = i;
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}