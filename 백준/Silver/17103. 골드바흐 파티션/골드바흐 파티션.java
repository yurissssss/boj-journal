import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 1000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        // 소수 -> 소수의 배수는 모두 X
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                // j = i 부터 시작하면 소수도 다 사라짐😢
                for (int j = i * 2; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;
            
            for (int j = 2; j <= num / 2; j++) {
                if (isPrime[j] && isPrime[num - j]) count++;
            }
            
            bw.write(count + "\n");
        }
        
        
        bw.flush();
        br.close();
        bw.close();
    }
}