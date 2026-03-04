import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        String letter = br.readLine();
       
        int sum = 0;
        
        for (int i = 0; i < num; i++) {
            sum += letter.charAt(i) -'0';
        }
        
        br.close();
        
        System.out.println(sum);
    }
}