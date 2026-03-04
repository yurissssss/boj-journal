import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] rem = new int[10];
        
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            
            rem[i] = num % 42;
        }
        
        Arrays.sort(rem);
        
        int count = 1;
        
        for (int i = 1; i < 10; i++) {
            if (rem[i] != rem[i-1]) count++;
        }
        
        System.out.println(count);
        
        br.close();
    }
}