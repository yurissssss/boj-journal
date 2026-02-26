import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        
        br.close();
        
        int b1 = B / 100;
        int b2 = (B / 10) % 10;
        int b3 = B % 10;
        
        System.out.println(A * b3);
        System.out.println(A * b2);
        System.out.println(A * b1);
        System.out.println(A * B);
    }
}