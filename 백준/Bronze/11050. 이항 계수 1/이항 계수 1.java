import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        System.out.print(factorial(n) / (factorial(k) * factorial(n- k)));
        
        br.close();
    }
    
    private static int factorial(int n) {
        int answer = 1;
        
        for (int i = 2; i <= n; i++) {
            answer *= i;
        }
        
        return answer;
    }
}