import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        
        for (int[] size : sizes) {
            if ((w >= size[0] && h >= size[1]) || (w >= size[1] && h >= size[0])) {
                continue;
            } else {
                int origin = Math.max(w, size[0]) * Math.max(h, size[1]);
                int reverse = Math.max(w, size[1]) * Math.max(h, size[0]);
                
                w = (origin <= reverse) ? Math.max(w, size[0]) : Math.max(w, size[1]);
                h = (origin <= reverse) ? Math.max(h, size[1]) : Math.max(h, size[0]);
            }
        }
        
        return w * h;
    }
}