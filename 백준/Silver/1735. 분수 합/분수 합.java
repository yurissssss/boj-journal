import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        
        int a3 = (a1 * b2) + (a2 * b1);
        int b3 = b1 * b2;
        
        System.out.println((a3 / gcd(a3, b3)) + " " + (b3 / gcd(a3, b3)));
        
        br.close();
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
}