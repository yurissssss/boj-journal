import java.util.*;


/**
0s  [0 0] [7 4 5 6]
1s  [0 7] [4 5 6]
2s  [7 0] [4 5 6]
3s  [0 4] [5 6]
4s  [4 5] [6]
5s  [5 0] [6]
6s  [0 6] []
7s  [6 0] []
8s  [0 0] []

선입선출 => 큐 사용
*/
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 최종시간
        int answer = 0;
        
        // 다리를 칸 단위로 표현
        Queue<Integer> bridge = new ArrayDeque<>();
        for(int i = 0 ; i < bridge_length ; i++)
            bridge.offer(0);
        
        // 기존 트럭을 deque
        Queue<Integer> waiting = new ArrayDeque<>();
        for (int w : truck_weights)
            waiting.offer(w);
        
        // 현 다리 위 총 무게
        int currentWeight = 0;
        
        // 남은 트럭이 모두 소모
        while (!waiting.isEmpty()){
            // 1초씩 경과
            answer++;
            
            // 다리 1칸 전진 -> 빠진 칸의 무게 제거
            currentWeight -= bridge.poll();
            
            // 다른 트럭을 올려도 무게 제한 넘지 않는다면
            int next = waiting.peek();
            if(currentWeight + next <= weight){
                bridge.offer(waiting.poll());
                // 총 무게 계산 (무게 갱신)
                currentWeight += next;
            }
            
            // 그렇지 않다면
            else{
                // 빈칸(0)만 추가로 넣어줌
                bridge.offer(0);
            }
        }
        
        // 마지막 트럭이 빠져 나오는 데 필요한 시간 추가
        answer += bridge_length;
        
        return answer;
    }
}