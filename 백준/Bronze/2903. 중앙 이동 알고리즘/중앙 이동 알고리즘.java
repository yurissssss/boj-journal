import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        int sum = 2;
        int mul = 1;
        
        for (int i = 1; i <= num; i++) {
            sum += mul;
            mul *= 2;
        }
        
        System.out.println(sum*sum);
        
        br.close();
    }
}