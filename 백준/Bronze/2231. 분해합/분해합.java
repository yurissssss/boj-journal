import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int start = n - ((int)Math.log10(n) + 1) * 9;
        if (start < 1) start = 1;

        for (int i = start; i < n; i++) {
            int sum = i;
            
            for (int x = i; x > 0; x /= 10) {
                sum += x % 10;
            }
            
            if (sum == n) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}