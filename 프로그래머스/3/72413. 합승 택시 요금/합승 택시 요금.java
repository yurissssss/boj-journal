import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] costs = new int[n + 1][n + 1];
        for (int[] fare : fares) {
            costs[fare[0]][fare[1]] = fare[2];
            costs[fare[1]][fare[0]] = fare[2];
        }
        
        Queue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        
        final int[] start = {s, a, b};
        
        int[][] minDist = new int[3][n + 1];
        for (int[] d : minDist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < 3; i++) {
            pq.offer(new int[]{start[i], 0});
            minDist[i][start[i]] = 0;
            
            while(!pq.isEmpty()) {
                int[] cur = pq.poll();
                
                if (minDist[i][cur[0]] < cur[1]) continue;
                
                for (int j = 1; j <= n; j++) {
                    // 연결 X
                    if (costs[cur[0]][j] == 0) continue;
                    
                    if(minDist[i][j] > cur[1] + costs[cur[0]][j]) {
                        minDist[i][j] = cur[1] + costs[cur[0]][j];
                        pq.offer(new int[]{j, minDist[i][j]});
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, minDist[0][i] + minDist[1][i] + minDist[2][i]);
        }
        
        return answer;
    }
}