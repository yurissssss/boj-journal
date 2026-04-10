import java.io.*;
import java.util.*;

public class Main {
    static long A, B, C;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        
        System.out.print(pow(A, B));
        br.close();
    }
    
    /*
    B가 짝수: A^(B) = A^(B/2) * A^(B/2)
            -> B = B/2 + B/2
    B가 홀수: A^(B) = A^((B-1)/2) * A^((B-1)/2) * A
            -> B = (B-1)/2 + (B-1)/2 + 1
    */
    
    /*
    A = 2, B = 4, C = 100
    pow(2, 4) -> temp = pow(2, 2)
        pow(2, 2) -> temp = pow(2, 1)
            pow(2, 1) = 2 % C -> return 2
        temp = 2 -> pow(2, 2) -> return (temp * temp) % C = 4
    temp = 4 -> pow(2, 4) -> return (temp * temp) % C = 16
    */
    private static long pow(long A, long B) {
        if (B == 1) {
            return A % C;
        }
        
        // B가 홀수 -> B/2가 내림값을 가지므로 B/2 = (B-1)/2
        long temp = pow(A, B / 2);
        
        if (B % 2 == 0) {
            return (temp * temp) % C;
        } else {
            return (((temp * temp) % C) * A) % C;
        }
    }
}