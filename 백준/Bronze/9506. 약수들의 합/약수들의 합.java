import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = 0;
        
        while((n = Integer.parseInt(br.readLine())) != -1) {
            findSum(n);
        }
        
        br.close();
    }
    
    public static void findSum(int n) {
        int sum = 1;
        
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" = 1");
        
        for (int i=2; i<=n/2; i++) {
            if ((n%i == 0)) {
                sum += i;
                sb.append(" + ").append(i);
            }
        }
        
        String answer;
        
        if (sum == n) {
            answer = sb.toString();
        } else answer = (n + " is NOT perfect.");
            
        System.out.println(answer);
    }
}