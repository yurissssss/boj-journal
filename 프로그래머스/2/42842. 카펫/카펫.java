class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        
        for (int i = 3; i * i <= area; i++) {
            if (area % i == 0) {
                int height = i;
                int width = area / i;
                
                if ((height - 2) * (width - 2) == yellow) {
                    return new int[]{width, height};
                }
            } else continue;
        }
        
        return new int[]{0, 0};
    }
}