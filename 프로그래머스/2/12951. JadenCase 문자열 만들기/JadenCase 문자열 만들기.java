class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        
        String answer = "";
        
        if (s.charAt(0) >= 97) answer += Character.toUpperCase(s.charAt(0));
        else answer += s.charAt(0);
        
        boolean isBlank = false;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c != ' ' && isBlank) {
                answer += Character.toUpperCase(c);
                isBlank = false;
            } else {
                answer += c;
                isBlank = c == ' ' ? true : false;
            }
        }
        
        return answer;
    }
}