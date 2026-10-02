import java.util.*;

class Solution {
    class Word{
        String word;
        int count;
        
        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
        
    public int solution(String begin, String target, String[] words) {
        Deque<Word> dq = new ArrayDeque<>();
        dq.offer(new Word(begin, 0));
        
        boolean[] visited = new boolean[words.length];
        
        while(!dq.isEmpty()) {
            Word cur = dq.poll();
            
            if (cur.word.equals(target)) return cur.count;
            
            for (int i = 0; i< words.length; i++) {
                if (!visited[i] && getDiffCount(cur.word, words[i]) == 1) {
                    visited[i] = true;
                    dq.offer(new Word(words[i], cur.count + 1));
                }
            }
        }
        
        return 0;
    }
    
    private int getDiffCount(String cur, String target) {
        int count = 0;
        
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != target.charAt(i)) count++;
        }
        
        return count;
    }
}