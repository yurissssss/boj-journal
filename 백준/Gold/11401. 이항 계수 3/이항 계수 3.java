import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int MOD = 1000000007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        long numerator = factorial(N);  // 분자
        long denominator = (factorial(K) * factorial(N - K)) % MOD;  // 분모
        
        long answer = (numerator * pow(denominator, MOD - 2)) % MOD;
        
        System.out.print(answer);
        br.close();
    }
    
    private static long factorial(int n) {
        long answer = 1;
        
        for (int i = 2; i <= n; i++) {
            answer = (answer * i) % MOD;
        }
        
        return answer;
    }
    
    private static long pow(long base, long exp) {
        if (exp == 0) {
            return 1;
        }
        
        long half = pow(base, exp / 2);
        long result = (half * half) % MOD;
        
        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        } 
        
        return result;
    }
}