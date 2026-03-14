import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            
            bw.write(findPrime(num) + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    public static long findPrime(long n) {
        if (n <= 2) return 2;
        
        while (true) {
            if (isPrime(n)) return n;
            
            n++;
        }
    }
    
    public static boolean isPrime(long n) {
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}