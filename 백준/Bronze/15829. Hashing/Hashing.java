import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        String s = br.readLine();
        long sum = 0;
        long pow = 1;
        long mow = 1234567891;
        
        for (int i = 0; i < n; i++) {
            int value = s.charAt(i) - 'a' + 1;
            
            sum = (sum + value * pow) % mow;
            pow = (pow * 31) % mow;
        }
        
        System.out.print(sum);
        
        br.close();
    }
}