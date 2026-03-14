import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = 1;
        
        while ((a = Integer.parseInt(br.readLine())) != 0) {
            int count = 0;
            
            for (int i = a + 1; i <= 2 * a; i++) {
                if (isPrime(i)) count++;
            }
            
            bw.write(count + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    public static boolean isPrime(int n) {
        if (n == 1) return false; 
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}