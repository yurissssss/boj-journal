class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            int x = Integer.parseInt(arr[i]);
            
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        
        return min + " " + max;
    }
}