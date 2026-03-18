import java.io.*;
import java.util.*;

class Recurs {
    int recurs;
    int count;
    
    Recurs(int recurs, int count) {
        this.recurs = recurs;
        this.count = count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            Recurs answer = isPalindrome(br.readLine(), 0);
            
            System.out.println(answer.recurs + " " + answer.count);
        }
        
        br.close();
    }
    
    private static Recurs recursion(char[] s, int l, int r, int count) {
        count++;
        
        if (l >= r) return new Recurs(1, count);  // 팰린드롬🅾️
        else if (s[l] != s[r]) return new Recurs(0, count);  // 팰린드롬❎
        else return recursion(s, l + 1,  r - 1, count);
    }
    
    private static Recurs isPalindrome(String s, int count) {
        char[] c = s.toCharArray();
        return recursion(c, 0, c.length - 1, count);
    }
}