import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = Integer.MIN_VALUE;
        int num = 0;
        int index = 0;
        
        for (int i = 0; i < 9; i++) {
            num = Integer.parseInt(br.readLine());
            
            if (num > max) {
                max = num;
                index = i + 1;
            }
        }
        
        br.close();
        
        System.out.println(max);
        System.out.println(index);
    }
}