class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        boolean isPositive = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                isPositive = false;
            } else if (s.charAt(i) == '+') {
                continue;
            } else { 
                answer *= 10;
                answer += s.charAt(i) - '0';
            }
        }
        
        return isPositive ? answer : answer * (-1);
    }
}