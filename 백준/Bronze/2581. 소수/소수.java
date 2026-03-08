import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
    
        int sum = 0;
        
        int min = n;;
    
        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                sum += i;
                min = (i < min) ? i : min;
            }
        }
    
        if (sum == 0) System.out.println("-1");
        else {
            System.out.println(sum);
            System.out.println(min);
        }
        
        br.close();
    }
    
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0) return false;
        }
        
        return true;
    }
}