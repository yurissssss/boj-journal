import java.util.*;

public class Solution {
    public int solution(int n) {
        int sum = 0;
        
        int r = n % 10;
        
        while (n != 0) {
            sum += r;
            n /= 10;
            r = n % 10;
        }
        
        return sum;
        
    }
}