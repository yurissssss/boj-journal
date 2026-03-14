import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long[] place = new long[n];
        long[] dis = new long[n - 1];
        
        for (int i = 0; i < n; i++) {
            place[i] = Long.parseLong(br.readLine());
            
            if (i > 0) {
                dis[i - 1] = place[i] - place[i - 1];
            }
        }
        
        long gcd = dis[0];
        
        for (int i = 1; i < n - 1; i++) {
            gcd = gcd(gcd, dis[i]);
        }
        
        long answer = 0;
        
        for (int i = 0; i < n - 1; i++) {
            answer += dis[i] / gcd - 1;
        }
        
        System.out.println(answer);
        
        br.close();
    }
    
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
}