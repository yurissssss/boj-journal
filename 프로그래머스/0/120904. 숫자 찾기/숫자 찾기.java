class Solution {
    public int solution(int num, int k) {
        String n = String.valueOf(num);
        
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == k + 48) return i + 1;
        }
        
        return -1;
    }
}