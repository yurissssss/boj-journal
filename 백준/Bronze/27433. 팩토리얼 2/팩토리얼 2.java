import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Integer.parseInt(br.readLine());
        
        System.out.print(factorial(n));
        
        br.close();
    }
    
    private static long factorial(long n) {
        long answer = 1;
        
        for (int i = 2; i <= n; i++) {
            answer *= i;
        }
        
        return answer;
    }
}