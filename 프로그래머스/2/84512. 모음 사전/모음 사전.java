class Solution {
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        int answer = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int rate = 0;
            
            for (int j = 0; j < 5 - i; j++) {
                rate += (int)Math.pow(5, j);
            }
            
            char c = word.charAt(i);
            for (int j = 0; j < 5; j++) {
                if (c == vowels[j]) {
                    answer += rate * j + 1;
                }
            }
        }
        
        return answer;
    }
}